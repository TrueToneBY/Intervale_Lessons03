package com.intervale.cources.library.external.alfabank.service.impl;



import com.intervale.cources.library.business.BooksRepository;
import com.intervale.cources.library.external.alfabank.model.NationalRate;
import com.intervale.cources.library.external.alfabank.model.NationalRateListResponse;
import com.intervale.cources.library.external.alfabank.model.Rate;
import com.intervale.cources.library.external.alfabank.model.RateListResponse;
import com.intervale.cources.library.model.BooksDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AlfaBankService {

    public AlfaBankService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    RestTemplate restTemplate;


    private  static final String URL = "https://developerhub.alfabank.by:8273/partner/1.0.1/public/rates";

    public List<Rate> getOpenAlfaBank() {
        return restTemplate.getForObject(URL, RateListResponse.class).getRates();
    }
}
