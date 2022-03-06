package com.intervale.cources.library.external.openlibrary.api;

import com.intervale.cources.library.external.openlibrary.OpenLibraryDocs;
import com.intervale.cources.library.external.openlibrary.service.OpenService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/app")
public class OpenLibraryController {
    @Autowired
    OpenService openService;

    @GetMapping
    public List<OpenLibraryDocs> getAllBooks(){
        log.info("Сработал GET запрос getAllBooks");
        return openService.getOpen();
    }
    @GetMapping(value = "/author{authorName}")
    public ResponseEntity<?> getBooksByAuthor(@PathVariable("authorName")String authorName){
        List<OpenLibraryDocs> books = openService.getOpenAuthor(authorName);
        if (books.toArray().length == 0){
            return new ResponseEntity<String>("Нет такой книги isbn " + authorName, HttpStatus.NOT_FOUND);
        }
        log.info("Сработал GET запрос /author/{authorName}");
        return new ResponseEntity<List>(books,HttpStatus.OK);
    }

    @GetMapping("/works:{author}")
    public  ResponseEntity<Object> getWorksByAuthor(@PathVariable  @Parameter(description = "Ф.И.О. автора.") @NotBlank String author) {
        ResponseEntity<Object> response;
        List<OpenLibraryDocs> works = openService.getOpenAuthor(author);
        if (works.size() != 0) {
            response = new ResponseEntity<>(works, HttpStatus.OK);
        }
        else {
            response = new ResponseEntity<>("No books found for author '" + author + "'.", HttpStatus.OK);
        }
        return response;
    }

}
