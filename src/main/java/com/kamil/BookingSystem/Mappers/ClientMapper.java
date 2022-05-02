package com.kamil.BookingSystem.Mappers;

import com.kamil.BookingSystem.DTO.ClientDTO;
import com.kamil.BookingSystem.Entity.Client;

public class ClientMapper {

    public static ClientDTO DTOMapper(Client client) {
        return ClientDTO.builder()
                .Id(client.getId())
                .name(client.getName())
                .surname(client.getSurname())
                .email(client.getEmail())
                .build();
    }

    public static Client ClientMapper(ClientDTO client) {
        return Client.builder()
                .Id(client.getId())
                .name(client.getName())
                .surname(client.getSurname())
                .email(client.getEmail())
                .build();
    }
}
