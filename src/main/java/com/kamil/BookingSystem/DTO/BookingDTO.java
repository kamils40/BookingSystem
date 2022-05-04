package com.kamil.BookingSystem.DTO;

import com.kamil.BookingSystem.Entity.Client;
import com.kamil.BookingSystem.Entity.Hotel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingDTO {
    Long id;
    @DateTimeFormat (pattern = "yyyy/MM/dd", iso = DateTimeFormat.ISO.DATE)
    LocalDate startsAt;
    @DateTimeFormat (pattern = "yyyy/MM/dd", iso = DateTimeFormat.ISO.DATE)
    LocalDate endsAt;
    Client client;
    Hotel hotel;
}

