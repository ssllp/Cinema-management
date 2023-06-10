package com.comic.controller.ex;

public class sessionisnullException extends RuntimeException {
    public sessionisnullException() {
        super();
    }

    public sessionisnullException(String message) {
        super(message);
    }

    public sessionisnullException(String message, Throwable cause) {
        super(message, cause);
    }

    public sessionisnullException(Throwable cause) {
        super(cause);
    }

    protected sessionisnullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
