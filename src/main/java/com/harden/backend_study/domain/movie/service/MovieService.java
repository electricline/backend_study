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

    public Movie recommendTodayMovie() {

        var query ="반지의 제왕";

        MovieGroup movieGroup = new MovieGroup(movieRepository.findByQuery(query));
        return movieGroup.getHighestRatingMovie().orElse(Movie.builder().title("기본영화").link("http://").userRating(9.9f).build());
    }

    public void initMovieLocalCache(){
        log.info("local cache init");
        movieLocalCache.clear();
    }

}
