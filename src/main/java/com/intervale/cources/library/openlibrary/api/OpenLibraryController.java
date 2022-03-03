package com.intervale.cources.library.openlibrary.api;

import com.intervale.cources.library.openlibrary.OpenLibraryDocs;
import com.intervale.cources.library.openlibrary.service.OpenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/app")
public class OpenLibraryController {
    @Autowired
    OpenService openService;

    @GetMapping
    public List<List<OpenLibraryDocs>> getAllBooks(){
        log.info("Сработал GET запрос getAllBooks");
        return openService.GetOpen();
    }

}
