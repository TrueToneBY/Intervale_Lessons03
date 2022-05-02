package com.intervale.cources.library.external.alfabank.api;



import com.intervale.cources.library.business.BooksRepository;
import com.intervale.cources.library.external.alfabank.model.Rate;
import com.intervale.cources.library.external.alfabank.service.impl.AlfaBankService;
import com.intervale.cources.library.model.BooksDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/apiAlfa")
public class AlfaControllers {
    @Autowired
    AlfaBankService alfaBankService;
    @Autowired
    BooksRepository booksRepository;

    /**
     *
     * @return
     */
    @GetMapping
    public List<Rate> getAllAlfaBank(){
        log.info("Сработал GET запрос getAllAlfaBank");
        return alfaBankService.getOpenAlfaBank();
    }

    @GetMapping("/euro")
    public List<Rate> getISO_EURO(){

        log.info("euro GET запрос getISO_EURO");
        return  alfaBankService.getISO_EURO();
    }

}
