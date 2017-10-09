package com.app.adu.usermanagement.exception;

import org.springframework.validation.Errors;

/**
 * @author Anish Panthi
 * <p>
 * 10/8/2017
 */
public class DataException extends BaseException{
    private final Errors errors;

    public DataException(String message, Errors errors) {
        super(message);
        this.errors = errors;
    }
}
