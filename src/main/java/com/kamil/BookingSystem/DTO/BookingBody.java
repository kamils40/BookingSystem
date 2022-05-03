package com.kamil.BookingSystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class BookingBody {
    LocalDate startsAt;
    LocalDate endsAt;
}
