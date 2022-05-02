package com.kamil.BookingSystem.Service;

import com.kamil.BookingSystem.DTO.ClientDTO;
import com.kamil.BookingSystem.Entity.Client;
import com.kamil.BookingSystem.Mappers.ClientMapper;
import com.kamil.BookingSystem.Repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientDTO addNewClient(ClientDTO clientDTO) {
        if(clientRepository.getByEmail(clientDTO.getEmail()).isPresent()) {
            throw new IllegalStateException();
        } else {
           Client client = clientRepository.save(ClientMapper.ClientMapper(clientDTO));
           clientDTO.setId(client.getId());
        }
        return clientDTO;
    }

    public ClientDTO getClientByEmail(String email) {
        return ClientMapper.DTOMapper(clientRepository.getByEmail(email).orElseThrow(
                () -> new NoSuchElementException()));
    }

    public List<ClientDTO> getAllClients() {
         return clientRepository.findAll()
                 .stream()
                 .map(ClientMapper::DTOMapper)
                 .collect(Collectors.toList());
    }

}