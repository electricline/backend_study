package com.harden.backend_study.domain.movie.controller;

import com.harden.backend_study.domain.movie.dto.Movie;
import com.harden.backend_study.domain.movie.service.MovieService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/search")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public List<Movie> getMoviesByQuery(@RequestParam("name") String query) {
        return movieService.search(query);
    }


    @GetMapping("initCache") @Scheduled(cron = "0 * * * * *") // 1분마다 실행
    public void initCache(){
        movieService.initBookLocalCache();
    }
}
