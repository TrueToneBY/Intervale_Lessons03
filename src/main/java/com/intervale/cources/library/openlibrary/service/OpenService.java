package com.intervale.cources.library.openlibrary.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.intervale.cources.library.openlibrary.OpenLibraryDocs;
import com.intervale.cources.library.openlibrary.OpenLibrarySearchResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OpenService {


    private static final String BASE_URL = "http://openlibrary.org/search.json?author={tolkien}";
    private final RestTemplate restTemplate;
//    private static final ObjectMapper mapper = new ObjectMapper();


    public OpenService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public List<List<OpenLibraryDocs>> processOpenLibrary(){
        ResponseEntity<OpenLibrarySearchResponse[]> responseEntity = restTemplate.getForEntity(BASE_URL,OpenLibrarySearchResponse[].class);
        OpenLibrarySearchResponse[] openArr = responseEntity.getBody();
        return Arrays.stream(openArr)
                .map(OpenLibrarySearchResponse::getDocs)
                .collect(Collectors.toList());
    }

//    public List<OpenLibrarySearchResponse> processQueryParameters(){
//        Map<String,String> params = new HashMap<>();
//        params.put("author","tolkien");
//        ResponseEntity<OpenLibrarySearchResponse[]> responses = restTemplate.getForEntity(BASE_URL,OpenLibrarySearchResponse[].class,params);
//        return Arrays.stream(responses.getBody()).toList();
//    }

}
