package com.kamil.BookingSystem.Service;

import com.kamil.BookingSystem.Repositories.ClientRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class ClientServiceTest {

    private ClientService underTest;
    @Mock
    private ClientRepository clientRepository;
    private AutoCloseable autoCloseable;
    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new ClientService(clientRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void addNewClient() {
    }

    @Test
    void getClientByEmail() {
    }

    @Test
    void getAllClients() {
        //when
        underTest.getAllClients();
        //then
        verify(clientRepository).findAll();
    }
}