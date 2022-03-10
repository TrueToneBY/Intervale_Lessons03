package com.intervale.cources.library.external.alfabank.service.impl;

import com.intervale.cources.library.external.alfabank.model.RateListResponse;
import com.intervale.cources.library.external.alfabank.service.AlfaBankService;
import io.swagger.client.model.NationalRate;
import io.swagger.client.model.NationalRateListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.client.RestTemplate;
import org.threeten.bp.LocalDate;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;

//public class AlfaBankServiceImpl implements AlfaBankService {
//    @Autowired
//    @Qualifier
//    RestTemplate restTemplate;
//
//    @Override
//    public RateListResponse getRatelist() {
//        return restTemplate.getForObject("/rates",RateListResponse.class);
//    }

//    @Override
//    public Map<String, BigDecimal> getRetelsInRange(String currency, int period) {
//        LocalDate dateStart = LocalDate.now().minusDays(period);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
//        Map<String, BigDecimal> rates = new LinkedHashMap<>();
//        NationalRateListResponse rateListResponse = restTemplate.getForObject("/nationalRates?date=" + formatter.toFormat(), NationalRateListResponse.class);
//        int currencyCode = 0;
//        for (NationalRate rate: rateListResponse.getRates()) {
//            if (rate.getIso().equalsIgnoreCase(currency)) {
//                currencyCode = rate.getCode();
//                rates.put(rate.getDate().format(formatter), rate.getRate());
//                break;
//            }
//        }
//        if (currencyCode != 0) {
//            LocalDate dateNow = LocalDate.now();
//            while (dateStart.isBefore(dateNow)) {
//                dateStart = dateStart.plusDays(1);
//                rateListResponse = restTemplate.getForObject("/nationalRates?date=" + formatter.format(dateStart) + "&currencyCode=" + currencyCode, NationalRateListResponse.class);
//                NationalRate nationalRate = rateListResponse.getRates().get(0);
//                rates.put(nationalRate.getDate().format(formatter), nationalRate.getRate());
//            }
//        }
//        return rates;
//    }
//}
