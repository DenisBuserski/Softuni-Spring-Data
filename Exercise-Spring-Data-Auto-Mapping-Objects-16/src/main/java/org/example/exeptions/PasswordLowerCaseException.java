package org.example.exeptions;

public class PasswordLowerCaseException extends RuntimeException {

    public PasswordLowerCaseException(String reason) {
        super(reason);
    }
}
