package com.df4j.v2.base.exception;

public class DfException extends RuntimeException{

    public DfException() {
        super();
    }

    public DfException(String message) {
        super(message);
    }


    public DfException(String message, Throwable cause) {
        super(message, cause);
    }


    public DfException(Throwable cause) {
        super(cause);
    }

    protected DfException(String message, Throwable cause,
                               boolean enableSuppression,
                               boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
