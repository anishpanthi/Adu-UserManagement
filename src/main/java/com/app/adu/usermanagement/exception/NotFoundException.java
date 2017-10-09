package com.app.adu.usermanagement.exception;

import com.app.adu.usermanagement.domain.error.Error;

/**
 * @author Anish Panthi
 * <p>
 * 10/8/2017
 */
public class NotFoundException extends BaseException{
    private final Error error;

    public NotFoundException(String message, Error errors) {
        super(message);
        this.error = errors;
    }
}
