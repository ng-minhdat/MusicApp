package com.eazybytes.backend.exception;

public class ArtistAlreadyExistsException extends RuntimeException {
    public ArtistAlreadyExistsException(String message) {
        super(message);
    }
}
