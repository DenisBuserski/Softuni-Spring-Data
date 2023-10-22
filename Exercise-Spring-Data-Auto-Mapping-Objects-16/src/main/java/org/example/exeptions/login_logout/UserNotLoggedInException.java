package org.example.exeptions.login_logout;

public class UserNotLoggedInException extends RuntimeException {
    public UserNotLoggedInException(String reason) {
        super(reason);
    }

}
