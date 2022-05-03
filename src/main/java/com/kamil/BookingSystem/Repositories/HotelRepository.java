package com.kamil.BookingSystem.Repositories;

import com.kamil.BookingSystem.Entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Long> {


    @Query("SELECT CASE WHEN COUNT(h) > 0 THEN " +
            "TRUE ELSE FALSE END " +
            "FROM Hotel h " +
            "WHERE h.name = ?1 " +
            "AND h.location = ?2")
    public boolean selectExistsByNameAndLocation(String name, String location);
}
