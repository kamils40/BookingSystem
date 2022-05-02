package com.kamil.BookingSystem.Repositories;

import com.kamil.BookingSystem.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {
}
