package com.harden.backend_study.domain.book.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Book {

    String title;
    String author;
    String isbn;

}
