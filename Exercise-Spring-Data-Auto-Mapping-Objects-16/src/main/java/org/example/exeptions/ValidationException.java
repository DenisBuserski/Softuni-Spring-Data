package org.example.exeptions;

public class ValidationException extends RuntimeException {

    public ValidationException(String reason) {
        super(reason);
    }
}
