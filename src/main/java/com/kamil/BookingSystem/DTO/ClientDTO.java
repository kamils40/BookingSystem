package com.kamil.BookingSystem.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kamil.BookingSystem.Entity.Booking;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Data
@Builder
public class ClientDTO {
    private long Id;
    private String name;
    private String surname;
    private String email;
    @JsonIgnore
    private List<Booking> bookings = new ArrayList<>();
}
