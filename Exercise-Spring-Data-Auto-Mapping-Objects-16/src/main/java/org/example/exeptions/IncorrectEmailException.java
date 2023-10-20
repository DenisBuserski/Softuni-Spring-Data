package org.example.exeptions;

public class IncorrectEmailException extends RuntimeException {

    public IncorrectEmailException(String reason) {
        super(reason);
    }
}
