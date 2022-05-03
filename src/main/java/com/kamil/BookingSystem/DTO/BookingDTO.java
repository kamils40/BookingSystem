package com.kamil.BookingSystem.DTO;

import com.kamil.BookingSystem.Entity.Client;
import com.kamil.BookingSystem.Entity.Hotel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    LocalDate startsAt;
    LocalDate endsAt;
    Client client;
    Hotel hotel;
}

