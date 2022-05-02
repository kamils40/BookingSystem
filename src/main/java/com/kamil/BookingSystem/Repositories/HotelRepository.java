package com.kamil.BookingSystem.Repositories;

import com.kamil.BookingSystem.Entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,Long> {
}
