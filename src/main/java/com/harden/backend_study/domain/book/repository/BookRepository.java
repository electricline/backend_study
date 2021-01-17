package com.harden.backend_study.domain.book.repository;

import com.harden.backend_study.domain.book.dto.Book;

import java.util.List;

public interface BookRepository {

    List<Book> findByQuery(String query);
}
