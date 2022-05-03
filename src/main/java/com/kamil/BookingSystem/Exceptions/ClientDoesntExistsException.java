package com.kamil.BookingSystem.Exceptions;

import java.util.NoSuchElementException;

public class ClientDoesntExistsException extends NoSuchElementException {

    public ClientDoesntExistsException(String message) {
        super(message);
    }
}
