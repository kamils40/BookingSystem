package com.kamil.BookingSystem.Exceptions;

import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.NoSuchElementException;

import static org.springframework.data.crossstore.ChangeSetPersister.*;

public class HotelDoesntExistsException extends NoSuchElementException {

    public HotelDoesntExistsException(String message) {
        super(message);
    }
}
