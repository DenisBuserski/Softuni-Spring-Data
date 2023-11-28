package org.example.exeptions;

public class IncorrectGameException extends RuntimeException {
    public IncorrectGameException(String reason) {
        super(reason);
    }

}
