package com.harden.backend_study.domain.book.service;

import com.harden.backend_study.cache.BookLocalCacheImpl;
import com.harden.backend_study.domain.book.dto.Book;
import com.harden.backend_study.domain.book.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BookService {

    private final BookRepository bookRepository;
    private final BookLocalCacheImpl bookLocalCache;

    public BookService(BookRepository bookRepository, BookLocalCacheImpl bookLocalCache) {
        this.bookRepository = bookRepository;
        this.bookLocalCache = bookLocalCache;
    }

    public List<Book> search(final String query){
        return bookRepository.findByQuery(query);
    }

    public void initBookLocalCache(){
        log.info("book local cache init");
        bookLocalCache.clear();
    }

}
