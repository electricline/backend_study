package com.harden.backend_study.domain.movie.repository;

import com.harden.backend_study.domain.movie.dto.Movie;

import java.util.List;

public interface MovieRepository {
    List<Movie> findByQuery(String query);
}
