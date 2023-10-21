package org.example.exeptions.registration;

public class PasswordLowerCaseException extends RuntimeException {

    public PasswordLowerCaseException(String reason) {
        super(reason);
    }
}
