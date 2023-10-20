package org.example.exeptions;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String reason) {
        super(reason);
    }

}
