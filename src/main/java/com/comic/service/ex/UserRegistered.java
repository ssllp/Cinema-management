package com.comic.service.ex;

public class UserRegistered extends RuntimeException {
    public UserRegistered() {
        super();
    }

    public UserRegistered(String message) {
        super(message);
    }

    public UserRegistered(String message, Throwable cause) {
        super(message, cause);
    }

    public UserRegistered(Throwable cause) {
        super(cause);
    }

    protected UserRegistered(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
