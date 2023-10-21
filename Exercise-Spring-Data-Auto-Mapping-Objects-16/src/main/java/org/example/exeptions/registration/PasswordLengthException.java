package org.example.exeptions.registration;

public class PasswordLengthException extends RuntimeException {

    public PasswordLengthException(String reason) {
        super(reason);
    }
}
