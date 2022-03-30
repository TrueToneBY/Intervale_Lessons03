//package com.intervale.cources.library.service;
//
//import com.intervale.cources.library.api.BookController;
//import com.intervale.cources.library.model.BooksDto;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.web.reactive.function.client.WebClient;
//import reactor.core.publisher.Mono;
//
//@Service
//@AllArgsConstructor
//public class BooksService {
//    public final WebClient webClient;
//
//    public Mono<BooksDto> getBooksByIdAsync(final String id){
//        return webClient
//                .get()
//                .uri(String.join("", "/books/", id))
//                .retrieve()
//                .bodyToMono(BooksDto.class);
//    }
//}
