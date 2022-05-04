package com.kamil.BookingSystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class BookingBody {
    @DateTimeFormat(pattern = "yyyy/MM/dd", iso = DateTimeFormat.ISO.DATE)
    LocalDate startsAt;
    @DateTimeFormat (pattern = "yyyy/MM/dd", iso = DateTimeFormat.ISO.DATE)
    LocalDate endsAt;
}
