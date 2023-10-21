package org.example.exeptions.registration;

public class ConfirmationPasswordException extends RuntimeException {

    public ConfirmationPasswordException(String reason) {
        super(reason);
    }
}
