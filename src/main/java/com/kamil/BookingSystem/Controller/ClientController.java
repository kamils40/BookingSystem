package com.kamil.BookingSystem.Controller;

import com.kamil.BookingSystem.DTO.ClientDTO;
import com.kamil.BookingSystem.Entity.Client;
import com.kamil.BookingSystem.Mappers.ClientMapper;
import com.kamil.BookingSystem.Service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/client")
public class ClientController {

    private final ClientService clientService;

    @PostMapping("/add")
    public ResponseEntity<ClientDTO> addNewClient(@RequestBody ClientDTO client) {
        clientService.addNewClient(client);
        return new ResponseEntity<>(client, HttpStatus.CREATED);
    }

    @GetMapping("/get/{email}")
    public ResponseEntity<ClientDTO> getClientByEmail(@PathVariable String email) {
        return new ResponseEntity<>(clientService.getClientByEmail(email),
                        HttpStatus.OK);
    }


}
