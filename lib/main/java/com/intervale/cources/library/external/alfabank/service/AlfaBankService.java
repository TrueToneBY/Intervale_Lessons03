package com.intervale.cources.library.external.alfabank.service;



import com.intervale.cources.library.external.alfabank.model.RateListResponse;

import java.math.BigDecimal;
import java.util.Map;

public interface AlfaBankService {
    RateListResponse getRateList();

    Map<String, BigDecimal> getRatesInRange(String currency, int period);
}
