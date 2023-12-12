package org.example.exeptions.games;

public class NotFoundGameException extends RuntimeException {
    public NotFoundGameException(String reason) {
        super(reason);
    }

}

