package com.breedish.ses.exception;

public abstract class BaseAppException extends Exception {

    private final int errorCode;

    private final int statusCode;

    BaseAppException(String message, int errorCode, int statusCode) {
        this(message, null, errorCode, statusCode);
    }

    BaseAppException(String message, Throwable cause, int errorCode, int statusCode) {
        super(message, cause);
        this.errorCode = errorCode;
        this.statusCode = statusCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
