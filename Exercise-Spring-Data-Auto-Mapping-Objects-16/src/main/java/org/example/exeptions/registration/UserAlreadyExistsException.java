package org.example.exeptions.registration;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String reason) {
        super(reason);
    }

}
