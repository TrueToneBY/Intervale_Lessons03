package com.intervale.cources.library.repository;

//import com.intervale.cources.library.external.openlibrary.OpenLibrarySearchResponse;
//import com.jayway.jsonpath.Configuration;
//import com.jayway.jsonpath.JsonPath;
//import com.jayway.jsonpath.Option;
//import com.jayway.jsonpath.spi.json.JacksonJsonProvider;
//import com.jayway.jsonpath.spi.json.JsonProvider;
//import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
//import com.jayway.jsonpath.spi.mapper.MappingProvider;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.*;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.Collections;
//import java.util.EnumSet;
//import java.util.Set;

//@SpringBootTest
//@RunWith(SpringRunner.class)
//@TestPropertySource(
//        locations = "classpath:application.yml")
//public class Run {
//    @Autowired
//    RestTemplate restTemplate;
//    @Test
//    public void runBefor(){
//        String sql ="http://openlibrary.org/search.json?author:{tolkien}";
//        String author = "tolkien";
//
//        //Get JSON as String
//        String jsonString = restTemplate.getForObject(sql, String.class, author);
//
////Configure JsonPath to use Jackson for mapping
//        Configuration.setDefaults(new Configuration.Defaults() {
//            private final JsonProvider jsonProvider = new JacksonJsonProvider();
//            private final MappingProvider mappingProvider = new JacksonMappingProvider();
//
//            @Override
//            public JsonProvider jsonProvider() {
//                return jsonProvider;
//            }
//
//            @Override
//            public MappingProvider mappingProvider() {
//                return mappingProvider;
//            }
//
//            @Override
//            public Set<Option> options() {
//                return EnumSet.noneOf(Option.class);
//            }
//        });
//
////Parse the JSON as a book
//        OpenLibrarySearchResponse book = JsonPath.parse(jsonString).read("$.author" + author, OpenLibrarySearchResponse.class);
//
//
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("author", "tolkien");
//        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//        HttpEntity<String> entity = new HttpEntity<String>(headers);
//        ResponseEntity<OpenLibrarySearchResponse[]> response = restTemplate.exchange(sql,HttpMethod.GET,entity,OpenLibrarySearchResponse[].class);
//        if (response.getStatusCode()==HttpStatus.OK){
//            for(OpenLibrarySearchResponse openLibrarySearchResponse : response.getBody())
//            {
//
//            }
//        }
//
//    }
//}
