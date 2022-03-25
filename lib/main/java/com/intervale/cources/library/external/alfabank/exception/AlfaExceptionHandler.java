//package com.intervale.cources.library.external.alfabank.exception;
//
//import org.checkerframework.checker.units.qual.C;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.client.ClientHttpResponse;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.ResponseErrorHandler;
//
//import java.io.IOException;
//import java.net.URI;
//
//@Component
//public class AlfaExceptionHandler implements ResponseErrorHandler {
//    @Override
//    public void handleError(URI url, HttpMethod method, ClientHttpResponse response) throws IOException {
//        if (response.getStatusCode().is4xxClientError()) {
//            throw  new AlfaBankRuntimeException("Unable to complete request to Alfa-Bank Public API. Bad request.");
//        } else if (response.getStatusCode().is5xxServerError()) {
//            throw  new AlfaBankRuntimeException("Failed to get response from Alfa-Bank Public API. Try again later.");
//        }
//    }
//
//    @Override
//    public boolean hasError(ClientHttpResponse response) throws IOException {
//        HttpStatus.Series statusCode = response.getStatusCode().series();
//        return statusCode == HttpStatus.Series.CLIENT_ERROR || statusCode == HttpStatus.Series.SERVER_ERROR;
//    }
//
//    @Override
//    public void handleError(ClientHttpResponse response) throws IOException {
//        if (response.getStatusCode().is4xxClientError()) {
//            throw  new AlfaBankRuntimeException("Unable to complete request to Alfa-Bank Public API. Bad request.");
//        } else if (response.getStatusCode().is5xxServerError()) {
//            throw  new AlfaBankRuntimeException("Failed to get response from Alfa-Bank Public API. Try again later.");
//        }
//    }
//}
