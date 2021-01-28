package com.harden.backend_study.domain.movie.service;

import com.harden.backend_study.cache.MovieLocalCacheImpl;
import com.harden.backend_study.domain.movie.dto.Movie;
import com.harden.backend_study.domain.movie.repository.MovieRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;
    @Mock
    private MovieLocalCacheImpl movieLocalCache;

    @Test
    @DisplayName("평점 순으로 정렬하기")
    void sortByScore() {

        //given
        given(movieRepository.findByQuery(anyString())).willReturn(getStubMovies());
        MovieService movieService = new MovieService(movieRepository,movieLocalCache);

        // when
        List<Movie> movieList = movieService.search("영화");

        // then
        var maxRating = 10f;
        var expectedTopRankMovieTitle = "영화3";
        Assertions.assertThat(expectedTopRankMovieTitle).isSameAs(movieList.stream().findFirst().get().getTitle());

        for(Movie movie : movieList){
            Assertions.assertThat(movie.getUserRating()).isLessThanOrEqualTo(maxRating);
            maxRating = movie.getUserRating();
        }
    }

    @Test
    @DisplayName("평점 8점 이상만 불러오기")
    void moreThan8userRating() {

        //given
        given(movieRepository.findByQuery(anyString())).willReturn(getStubMovies());
        MovieService movieService = new MovieService(movieRepository, movieLocalCache);

        //when
        List<Movie> movieList = movieService.search("영화");

        //then
        movieList.stream().forEach(movie ->  {
            Assertions.assertThat(movie.getUserRating()).isGreaterThanOrEqualTo(8f);
        });

    }

    List<Movie> getStubMovies() {
        return Arrays.asList(
                Movie.builder().title("영화1").link("http://test").userRating(9.3f).build(),
                Movie.builder().title("영화2").link("http://test").userRating(8.7f).build(),
                Movie.builder().title("영화3").link("http://test").userRating(9.7f).build()
        );
    }
}