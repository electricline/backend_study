package com.harden.backend_study.domain.book.service;

import com.harden.backend_study.domain.book.dto.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BookServiceTest {

    @Autowired
    BookService bookService;

    @Test
    @DisplayName("책 검색 기능")
    public void search() {

        String title = "객체지향";

        List<Book> bookList = bookService.search(title);

        for(Book book : bookList){
            org.assertj.core.api.Assertions.assertThat(book.getTitle().replaceAll(" ","")).contains(title);
        }

    }

}