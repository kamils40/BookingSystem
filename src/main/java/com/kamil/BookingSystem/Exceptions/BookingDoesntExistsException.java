package com.kamil.BookingSystem.Exceptions;

import java.util.NoSuchElementException;

public class BookingDoesntExistsException extends NoSuchElementException {

    public BookingDoesntExistsException(String message) {
        super(message);
    }
}
