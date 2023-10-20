package org.example.exeptions;

public class ConfirmationPasswordException extends RuntimeException {

    public ConfirmationPasswordException(String reason) {
        super(reason);
    }
}
