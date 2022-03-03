package com.intervale.cources.library.openlibrary.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.intervale.cources.library.openlibrary.OpenLibraryDocs;
import com.intervale.cources.library.openlibrary.OpenLibrarySearchResponse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OpenService {


    private static final String BASE_URL = "https://openlibrary.org/search.json?q=the+lord+of+the+rings&page=2";
    private final RestTemplate restTemplate;
    private static final ObjectMapper mapper = new ObjectMapper();


    public OpenService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<List<OpenLibraryDocs>> GetOpen(){
       ResponseEntity<List<OpenLibrarySearchResponse>> responseEntity =
               restTemplate.exchange(BASE_URL,
                       HttpMethod.GET,
                       null,
                       new ParameterizedTypeReference<List<OpenLibrarySearchResponse>>() {});
       List<OpenLibrarySearchResponse> open = responseEntity.getBody();
       return open.stream()
               .map(OpenLibrarySearchResponse::getDocs)
               .collect(Collectors.toList());
    }



    public List<List<OpenLibraryDocs>> processOpenLibrary(){
        ResponseEntity<OpenLibrarySearchResponse[]> responseEntity = restTemplate.getForEntity(BASE_URL,OpenLibrarySearchResponse[].class);
        OpenLibrarySearchResponse[] openArr = responseEntity.getBody();
        log.info("до return");
        return Arrays.stream(openArr)
                .map(OpenLibrarySearchResponse::getDocs)
                .collect(Collectors.toList());
    }


}
