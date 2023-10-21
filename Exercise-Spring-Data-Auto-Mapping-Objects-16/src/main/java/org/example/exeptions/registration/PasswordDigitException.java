package org.example.exeptions.registration;

public class PasswordDigitException extends RuntimeException {

    public PasswordDigitException(String reason) {
        super(reason);
    }
}
