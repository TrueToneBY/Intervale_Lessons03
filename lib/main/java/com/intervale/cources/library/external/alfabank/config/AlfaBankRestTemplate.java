//package com.intervale.cources.library.external.alfabank.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.web.client.RestTemplateBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.client.ResponseErrorHandler;
//
//import java.io.IOException;
//
//@Configuration
//public class AlfaBankRestTemplate {
//
//    @Autowired
//    AlfaBankConfig config;
//
//    /**
//     * Добавляет к RestTemplate базовый URL, ErrorHandler, Interceptor для обращения к API Альфа-банка
//     * @return сконфигурированный RestTemplate
//     */
//    @Bean("AlfaBank")
//    public RestTemplateBuilder restTemplate() {
//        return new RestTemplateBuilder().rootUri(config.getBaseUrl()).errorHandler((ResponseErrorHandler) new IOException());
//    }
//}
