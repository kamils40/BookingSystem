package com.kamil.BookingSystem.Mappers;

import com.kamil.BookingSystem.DTO.BookingDTO;
import com.kamil.BookingSystem.Entity.Booking;

public class BookingMapper {

    public static BookingDTO DTOMapper(Booking booking) {
        return BookingDTO.builder()
                .id(booking.getId())
                .client(booking.getClient())
                .hotel(booking.getHotel())
                .startsAt(booking.getStartsAt())
                .endsAt(booking.getEndsAt())
                .build();
    }
    public static Booking BookingMapper(BookingDTO booking) {
        return Booking.builder()
                .id(booking.getId())
                .client(booking.getClient())
                .hotel(booking.getHotel())
                .startsAt(booking.getStartsAt())
                .endsAt(booking.getEndsAt())
                .build();
    }
}
