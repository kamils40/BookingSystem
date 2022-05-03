package com.kamil.BookingSystem.Repositories;

import com.kamil.BookingSystem.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {

    @Query("SELECT b FROM Booking b WHERE b.client_id = ?1")
    public List<Booking> getAllBookingsOfClient(Long id);

    @Query("SELECT b FROM Booking b WHERE b.hotel_id = ?1")
    public List<Booking> getAllBookingsOfHotel(Long id);
}
