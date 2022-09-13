package com.example.slavinntube.exeptionhandling.user;

public class UserExistsException extends Exception{


    public UserExistsException(String message) {
        super(message,null,false,false);
    }

    public UserExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserExistsException(Throwable cause) {
        super(cause);
    }
}
