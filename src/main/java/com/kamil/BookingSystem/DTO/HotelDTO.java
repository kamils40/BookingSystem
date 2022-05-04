package com.kamil.BookingSystem.DTO;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kamil.BookingSystem.Entity.Booking;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelDTO {
    Long id;
    String name;
    String location;
    @JsonIgnore
    List<Booking> bookings = new ArrayList<>();
}
