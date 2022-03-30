package com.intervale.cources.library.external.alfabank.service.impl;



import com.intervale.cources.library.external.alfabank.model.Rate;
import com.intervale.cources.library.external.alfabank.model.RateListResponse;
import com.intervale.cources.library.model.BooksDto;
import com.intervale.cources.library.repository.BooksDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class AlfaBankService {
    @Autowired
    BooksDAO booksDAO;

    public AlfaBankService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Autowired
    RestTemplate restTemplate;


    private  static final String URL = "https://developerhub.alfabank.by:8273/partner/1.0.1/public/rates";

    public List<Rate> getOpenAlfaBank() {


        return restTemplate.getForObject(URL, RateListResponse.class).getRates().stream().toList();
    }

    public List<Rate> getISO_EURO() {
        List<Rate> rates = restTemplate.getForObject(URL, RateListResponse.class).getRates();


        return Collections.singletonList(rates.get(0));
    }

}
