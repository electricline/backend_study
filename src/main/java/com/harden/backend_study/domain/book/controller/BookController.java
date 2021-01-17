package com.harden.backend_study.domain.book.controller;

import com.harden.backend_study.domain.book.dto.Book;
import com.harden.backend_study.domain.book.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/v1/search")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("books")
    public List<Book> getBookByQuery(@RequestParam("d_titl") String query){
        return bookService.search(query);
    }
}
