package com.kamil.BookingSystem.Exceptions;

import java.util.NoSuchElementException;

public class UserDoesntExistsException extends NoSuchElementException {

    public UserDoesntExistsException(String message) {
        super(message);
    }
}
