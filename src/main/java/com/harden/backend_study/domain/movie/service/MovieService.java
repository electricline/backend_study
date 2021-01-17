package com.harden.backend_study.domain.movie.service;

import com.harden.backend_study.domain.movie.dto.Movie;
import com.harden.backend_study.domain.movie.dto.MovieGroup;
import com.harden.backend_study.domain.movie.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {


    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> search(final String query){
        return new MovieGroup(movieRepository.findByQuery(query)).getListOrderRating();
    }
}
