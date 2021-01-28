package com.harden.backend_study.domain.movie.repository;


import com.harden.backend_study.cache.MovieLocalCacheImpl;
import com.harden.backend_study.domain.movie.dto.Movie;
import com.harden.backend_study.domain.movie.dto.ResponseMovie;
import com.harden.backend_study.config.NaverProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class MovieRepositoryImpl implements MovieRepository {

    private final RestTemplate restTemplate;
    private final NaverProperties naverProperties;
    private final MovieLocalCacheImpl movieLocalCache;

    public MovieRepositoryImpl(RestTemplate restTemplate, NaverProperties naverProperties, MovieLocalCacheImpl movieLocalCache) {
        this.restTemplate = restTemplate;
        this.naverProperties = naverProperties;
        this.movieLocalCache = movieLocalCache;
    }

    @Override
    public List<Movie> findByQuery(final String query) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Naver-Client-Id", naverProperties.getClientId());
        httpHeaders.add("X-Naver-Client-Secret", naverProperties.getClientSecret());
        String url = naverProperties.getMovieUrl() + "?query=" + query;

        if(movieLocalCache.containsKey(query)){
            log.info("cache call");
            return (List<Movie>) movieLocalCache.get(query);
        }

        List<Movie> movieList = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(httpHeaders), ResponseMovie.class)
                .getBody()
                .getItems()
                .stream()
                .filter(m -> m.getUserRating() > 8)
                .map(m -> Movie.builder()
                        .title(m.getTitle())
                        .link(m.getLink())
                        .userRating(m.getUserRating())
                        .build())
                .collect(Collectors.toList());

        movieLocalCache.put(query, movieList);
        log.info("cache miss");
        return (List<Movie>) movieLocalCache.get(query);

    }
}
