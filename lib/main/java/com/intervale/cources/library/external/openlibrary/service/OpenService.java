package com.intervale.cources.library.external.openlibrary.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.intervale.cources.library.external.openlibrary.OpenLibraryDocs;
import com.intervale.cources.library.external.openlibrary.OpenLibrarySearchResponse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OpenService {
    private static final String BASE_URL = "https://openlibrary.org/search.json?q=the+lord+of+the+rings&page=2";
    private static final String BASE_URL_AUTHOR = "https://openlibrary.org/search.json?author=";
    private final RestTemplate restTemplate;
   // private static final ObjectMapper mapper = new ObjectMapper();


    public OpenService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<OpenLibraryDocs> getOpen(){
       ResponseEntity<OpenLibrarySearchResponse> responseEntity =
               restTemplate.exchange(BASE_URL,
                       HttpMethod.GET,
                       null,
                       new ParameterizedTypeReference<OpenLibrarySearchResponse>() {});
       OpenLibrarySearchResponse open = responseEntity.getBody();
       return open.getDocs();
    }

    public List<OpenLibraryDocs> getOpenAuthor(String authorName) {
        return restTemplate.getForObject(BASE_URL_AUTHOR + authorName, OpenLibrarySearchResponse.class).getDocs();
    }
}

