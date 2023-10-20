package org.example.exeptions;

public class PasswordLengthException extends RuntimeException {

    public PasswordLengthException(String reason) {
        super(reason);
    }
}
