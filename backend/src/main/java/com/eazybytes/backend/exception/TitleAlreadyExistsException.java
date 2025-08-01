package com.eazybytes.backend.exception;

public class TitleAlreadyExistsException extends RuntimeException {
  public TitleAlreadyExistsException(String message) {
    super(message);
  }
}
