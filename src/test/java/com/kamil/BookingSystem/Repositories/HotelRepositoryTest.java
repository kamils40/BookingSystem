package com.kamil.BookingSystem.Repositories;

import com.kamil.BookingSystem.Entity.Hotel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class HotelRepositoryTest {

    @Autowired
    HotelRepository underTest;

    @Test
    void ItShouldExistsByNameAndLocation() {
        //given
        Hotel hotel = new Hotel(
                0L,
                "Warsawia",
                "Warsaw"

        );
        underTest.save(hotel);
        //when
        boolean result = underTest.selectExistsByNameAndLocation("Warsawia", "Warsaw");
        //then
        assertThat(result).isTrue();
    }

    @Test
    void ItShouldntExistsByNameAndLocation() {
        //given
        Hotel hotel = new Hotel(
                0L,
                "Warsawia",
                "Warsaw"

        );
        underTest.save(hotel);
        //when
        boolean result = underTest.selectExistsByNameAndLocation("Okecie Airport Hotel", "Warsaw");
        //then
        assertThat(result).isFalse();
    }

    @Test
    void ItAlsoShouldntExistsByNaemAndLocation() {
        //given
        Hotel hotel = new Hotel(
                0L,
                "Warsawia",
                "Warsaw"

        );
        underTest.save(hotel);
        //when
        boolean result = underTest.selectExistsByNameAndLocation("Warsawia", "New York");
        //then
        assertThat(result).isFalse();
    }
}