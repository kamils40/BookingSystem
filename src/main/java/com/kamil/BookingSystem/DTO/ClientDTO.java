package com.kamil.BookingSystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@AllArgsConstructor
@Data
@Builder
public class ClientDTO {
    private long Id;
    private String name;
    private String surname;
    private String email;
}
