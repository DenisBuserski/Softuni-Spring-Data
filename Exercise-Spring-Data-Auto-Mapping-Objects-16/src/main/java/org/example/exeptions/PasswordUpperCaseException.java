package org.example.exeptions;

public class PasswordUpperCaseException extends RuntimeException {

    public PasswordUpperCaseException(String reason) {
        super(reason);
    }
}
