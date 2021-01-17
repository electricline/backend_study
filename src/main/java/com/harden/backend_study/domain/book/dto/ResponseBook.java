package com.harden.backend_study.domain.book.dto;

import com.harden.backend_study.domain.movie.dto.ResponseMovie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseBook {

    private List<ResponseBook.Item> items;

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Item {
        private String title;
        private String link;
        private String image;
        private String author;
        private Date price;
        private String discount;
        private String publisher;
        private String isbn;
    }

}
