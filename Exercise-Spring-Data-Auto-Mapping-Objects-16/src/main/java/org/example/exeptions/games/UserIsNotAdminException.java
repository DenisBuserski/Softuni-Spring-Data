package org.example.exeptions.games;

public class UserIsNotAdminException extends RuntimeException {
    public UserIsNotAdminException(String reason) {
        super(reason);
    }

}

