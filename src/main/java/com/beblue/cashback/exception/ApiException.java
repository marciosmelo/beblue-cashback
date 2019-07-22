package com.beblue.cashback.exception;

public class ApiException extends Exception {

    private static final long serialVersionUID = 992971926160511772L;

    public ApiException() {
        super();
    }
    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }
    public ApiException(Throwable cause) {
        super(cause);
    }

    private int errorCode;
    private String errorMessage;

    public ApiException(String message) {
        super(message);
        this.errorMessage = message;
    }
    public ApiException(String message, int errorCode) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = message;
    }


    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
}

