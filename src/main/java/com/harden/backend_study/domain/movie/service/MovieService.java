package com.harden.backend_study.domain.movie.service;

import com.harden.backend_study.cache.MovieLocalCacheImpl;
import com.harden.backend_study.domain.movie.dto.Movie;
import com.harden.backend_study.domain.movie.dto.MovieGroup;
import com.harden.backend_study.domain.movie.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MovieService {

    private final MovieRepository movieRepository;
    private final MovieLocalCacheImpl movieLocalCache;

    public MovieService(MovieRepository movieRepository, MovieLocalCacheImpl movieLocalCache) {
        this.movieRepository = movieRepository;
        this.movieLocalCache = movieLocalCache;
    }

    public List<Movie> search(final String query){
        return new MovieGroup(movieRepository.findByQuery(query)).getListOrderRating();
    }

    public void initBookLocalCache(){
        log.info("book local cache init");
        movieLocalCache.clear();
    }

}
