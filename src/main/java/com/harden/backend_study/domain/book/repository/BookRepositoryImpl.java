package com.harden.backend_study.domain.book.repository;

import com.harden.backend_study.config.NaverProperties;
import com.harden.backend_study.domain.book.dto.Book;
import com.harden.backend_study.domain.book.dto.ResponseBook;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookRepositoryImpl implements BookRepository {

    private final RestTemplate restTemplate;
    private final NaverProperties naverProperties;

    public BookRepositoryImpl(RestTemplate restTemplate, NaverProperties naverProperties) {
        this.restTemplate = restTemplate;
        this.naverProperties = naverProperties;
    }


    @Override
    public List<Book> findByQuery(String query) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Naver-Client-Id", naverProperties.getClientId());
        httpHeaders.add("X-Naver-Client-Secret", naverProperties.getClientSecret());
        String url = naverProperties.getBookUrl() + "?query=" + query;

        return restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(httpHeaders), ResponseBook.class)
                .getBody()
                .getItems()
                .stream()
                .map(b -> Book.builder()
                        .title(b.getTitle())
                        .author(b.getAuthor())
                        .isbn(b.getIsbn())
                        .build())
                    .collect(Collectors.toList());
    }
}
