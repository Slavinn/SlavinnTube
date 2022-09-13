package com.example.slavinntube.exeptionhandling.user;

public class UserNotFoundException extends RuntimeException  {

    public UserNotFoundException(String message) {
        super(message);
    }
    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public  UserNotFoundException(Throwable cause) {
        super(cause);
    }

}
