package com.intervale.cources.library.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;

@Slf4j
@Service
public class BooksErrorHandler extends DefaultResponseErrorHandler {
    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        log.error(response.getStatusCode().toString());
        log.error(StreamUtils.copyToString(response.getBody(),Charset.defaultCharset()));
    }
}
