package org.example.exeptions.login_logout;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String reason) {
        super(reason);
    }

}
