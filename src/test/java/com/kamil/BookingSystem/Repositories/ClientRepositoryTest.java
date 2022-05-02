package com.kamil.BookingSystem.Repositories;

import com.kamil.BookingSystem.Entity.Client;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ClientRepositoryTest {

    @Autowired
    private ClientRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }
    @Test
    void ItShouldGetClientByEmailIfItExists() {
        //given
        String email = "michaelburch@gmail.com";
        Client client = new Client(
                "Michael",
                "Burch",
                "michaelburch@gmail.com"
        );
        underTest.save(client);
        //when
        Client tested = underTest.getByEmail(email).get();
        //then
        assertThat(tested.getEmail()).isEqualTo(email);
    }

    @Test
    void ItShouldntGetClientByEmailIfItDoesntExists() {
        //given
        String email = "michaelburch@gmail.com";
        //when
        boolean tested = underTest.getByEmail(email).isPresent();
        //then
        assertThat(tested).isEqualTo(false);
    }
}