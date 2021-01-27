package com.harden.backend_study.domain.movie.dto;

import lombok.Getter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
public class MovieGroup {

    private final List<Movie> list;


    public MovieGroup(List<Movie> list) {
        this.list = list;
    }

    public List<Movie> getListOrderRating() {
        return list.stream()
                .filter(b -> !((Float)b.getUserRating()).equals(0.0f))
                .sorted((a,b) -> b.getUserRating() > a.getUserRating() ? 1 : -1)
                .collect(Collectors.toList());
    }

    public Optional<Movie> getHighestRatingMovie() {
        return getListOrderRating().stream().findFirst();
    }

}
