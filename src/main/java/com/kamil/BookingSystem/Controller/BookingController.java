package com.kamil.BookingSystem.Controller;


import com.kamil.BookingSystem.DTO.BookingBody;
import com.kamil.BookingSystem.DTO.BookingDTO;
import com.kamil.BookingSystem.Entity.Booking;
import com.kamil.BookingSystem.Service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/booking")
@AllArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/add/{clientId}/hotel/{hotelId}")
    public ResponseEntity<BookingDTO> addBooking(@RequestBody BookingBody body,
                                                 @PathVariable Long clientId, @PathVariable Long hotelId) {
        return new ResponseEntity<>(bookingService.addBooking(body,clientId,hotelId), HttpStatus.CREATED);

    }

    @GetMapping("/all")
    public ResponseEntity<List<BookingDTO>> getAllBookings() {
        return new ResponseEntity<>(bookingService.getAllBookings(),HttpStatus.OK);
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<BookingDTO>> getBookingsOfClient(@PathVariable Long clientId) {
        return new ResponseEntity<>(bookingService.getBookingsOfAClient(clientId),HttpStatus.OK);
    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<BookingDTO>> getBookingsOfHotel(@PathVariable Long hotelId) {
        return new ResponseEntity<>(bookingService.getBookingsOfAHotel(hotelId),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{bookingId}")
    public ResponseEntity<BookingDTO> deleteBooking(@PathVariable Long bookingId) {
        return new ResponseEntity<>(bookingService.removeBooking(bookingId),HttpStatus.OK);
    }

}
