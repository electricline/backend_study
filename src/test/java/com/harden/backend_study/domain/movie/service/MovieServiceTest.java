package com.harden.backend_study.domain.movie.service;

import com.harden.backend_study.domain.movie.dto.Movie;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MovieServiceTest {

    @Autowired
    MovieService movieService;

    @Test
    @DisplayName("평점 순으로 정렬하기")
    void search() {
        List<Movie> movieList = movieService.search("반지의제왕");

        float maxRating = 10;

        for(Movie movie : movieList){
            Assertions.assertThat(movie.getUserRating()).isLessThanOrEqualTo(maxRating);
            maxRating = movie.getUserRating();
        }
    }
}