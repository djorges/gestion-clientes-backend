package com.example.gestionclientesexample.exception;

public class ClienteNotFoundException extends RuntimeException {
    public ClienteNotFoundException(String message) {
        super(message);
    }
    public ClienteNotFoundException(String message,Throwable cause) {
        super(message, cause);
    }
}
