package org.example.exeptions;

public class UserNotLoggedInException extends RuntimeException {
    public UserNotLoggedInException(String reason) {
        super(reason);
    }

}
