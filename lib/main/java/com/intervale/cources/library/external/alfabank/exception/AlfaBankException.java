package com.intervale.cources.library.external.alfabank.exception;

public class AlfaBankException extends RuntimeException {
    public AlfaBankException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "Exception in Alfa-Bank public API: " + getMessage();
    }
}
