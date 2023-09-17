package org.example.exeptions;

public class UserNotLoggedInException extends RuntimeException {
    public UserNotLoggedInException() {
        super("Execute Login command first!");
    }
}
