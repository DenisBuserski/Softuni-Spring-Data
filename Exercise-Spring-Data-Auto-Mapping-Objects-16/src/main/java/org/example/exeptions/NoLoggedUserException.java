package org.example.exeptions;

public class NoLoggedUserException extends RuntimeException {
    public NoLoggedUserException(String reason) {
        super(reason);
    }

}
