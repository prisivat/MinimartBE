package com.example.EShop.Exception;

public class EmailAndPhoneNumberAlreadyExistsException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EmailAndPhoneNumberAlreadyExistsException(String exception) {
        super(exception);
    }
}