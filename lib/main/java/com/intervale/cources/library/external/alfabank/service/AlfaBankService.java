package com.intervale.cources.library.external.alfabank.service;

import com.intervale.cources.library.external.alfabank.model.RateListResponse;

import java.math.BigDecimal;
import java.util.Map;

public interface AlfaBankService {
    RateListResponse getRatelist();

    Map<String, BigDecimal> getRetelsInRange(String currency,int period);
}
