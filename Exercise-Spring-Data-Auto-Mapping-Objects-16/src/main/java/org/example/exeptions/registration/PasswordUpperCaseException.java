package org.example.exeptions.registration;

public class PasswordUpperCaseException extends RuntimeException {

    public PasswordUpperCaseException(String reason) {
        super(reason);
    }
}
