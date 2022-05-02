package com.intervale.cources.library.exception;

import org.springframework.stereotype.Service;

@SuppressWarnings("serial")
public class BookNotFoundException extends RuntimeException{
    private Integer id;
    public BookNotFoundException(Integer id) {
        super(String.format("Books is not found with id : '%s'", id));
    }
}
