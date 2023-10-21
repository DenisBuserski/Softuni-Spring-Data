package org.example.exeptions.registration;

public class IncorrectEmailException extends RuntimeException {

    public IncorrectEmailException(String reason) {
        super(reason);
    }
}
