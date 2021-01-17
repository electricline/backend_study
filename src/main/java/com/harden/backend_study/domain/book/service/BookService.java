package com.harden.backend_study.domain.book.service;

import com.harden.backend_study.domain.book.dto.Book;
import com.harden.backend_study.domain.book.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public List<Book> search(final String query){
        return bookRepository.findByQuery(query);
    }

}
