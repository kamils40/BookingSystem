package com.kamil.BookingSystem.Exceptions;

public class HotelAlreadyExistsException extends IllegalStateException{

    public HotelAlreadyExistsException(String message) {
        super(message);
    }
}
