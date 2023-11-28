package org.example.exeptions.games;

public class IncorrectGameException extends RuntimeException {
    public IncorrectGameException(String reason) {
        super(reason);
    }

}
