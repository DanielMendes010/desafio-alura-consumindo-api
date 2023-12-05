package com.br.cep.exception;

public class CepConversionException extends RuntimeException {
    private String message;

    public CepConversionException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
