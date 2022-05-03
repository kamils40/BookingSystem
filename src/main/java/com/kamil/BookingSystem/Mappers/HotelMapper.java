package com.kamil.BookingSystem.Mappers;

import com.kamil.BookingSystem.DTO.HotelDTO;
import com.kamil.BookingSystem.Entity.Hotel;

public class HotelMapper {

    public static HotelDTO DTOMapper(Hotel hotel) {
        return HotelDTO.builder()
                .id(hotel.getId())
                .bookings(hotel.getBookings())
                .name(hotel.getName())
                .location(hotel.getLocation())
                .build();
    }

    public static Hotel DTOMapper(HotelDTO hotel) {
        return Hotel.builder()
                .id(hotel.getId())
                .bookings(hotel.getBookings())
                .name(hotel.getName())
                .location(hotel.getLocation())
                .build();
    }
}
