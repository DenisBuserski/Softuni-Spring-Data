package org.example.exeptions;

public class PasswordDigitException extends RuntimeException {

    public PasswordDigitException(String reason) {
        super(reason);
    }
}
