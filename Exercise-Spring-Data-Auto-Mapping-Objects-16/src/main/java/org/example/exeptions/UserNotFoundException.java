package org.example.exeptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String reason) {
        super(reason);
    }

}
