package com.kamil.BookingSystem.Exceptions;

public class ClientAlreadyExistsException extends IllegalStateException{

    public ClientAlreadyExistsException(String message) {
        super(message);
    }
}
