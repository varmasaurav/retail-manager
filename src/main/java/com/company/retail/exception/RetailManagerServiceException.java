package com.company.retail.exception;

import org.springframework.http.HttpStatus;

import javax.validation.constraints.NotNull;

/**
 * Created by saurav on 1/9/16.
 */
public class RetailManagerServiceException extends RuntimeException {

    @NotNull
    private HttpStatus httpStatusCode;

    public RetailManagerServiceException(Exception e, String message, HttpStatus httpStatusCode) {
        super(message, e);
        this.httpStatusCode = httpStatusCode;
    }

    public RetailManagerServiceException(String message, HttpStatus httpStatusCode) {
        super(message);
        this.httpStatusCode = httpStatusCode;
    }

    public HttpStatus getHttpStatusCode() {
        return httpStatusCode;
    }
}
