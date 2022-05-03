package com.kamil.BookingSystem.Exceptions;

public class UserAlreadyExistsException extends IllegalStateException{

    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
