package com.projElektra.domain.exceptions;

public class MySqlException extends RuntimeException {

    private final int httpStatus;

    public MySqlException(String message, int httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public int getHttpStatus() {
        return httpStatus;
    }
}