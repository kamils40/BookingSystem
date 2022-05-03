package com.kamil.BookingSystem.DTO;


import com.kamil.BookingSystem.Entity.Booking;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelDTO {
    Long id;
    String name;
    String location;
    List<Booking> bookings;
}
