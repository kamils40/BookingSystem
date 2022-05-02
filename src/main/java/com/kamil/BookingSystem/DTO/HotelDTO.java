package com.kamil.BookingSystem.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kamil.BookingSystem.Entity.Booking;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.OneToMany;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
public class HotelDTO {
    Long id;
    String name;
    String location;
    List<Booking> bookings;
}
