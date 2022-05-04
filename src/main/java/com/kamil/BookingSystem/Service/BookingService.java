package com.kamil.BookingSystem.Service;

import com.kamil.BookingSystem.DTO.BookingBody;
import com.kamil.BookingSystem.DTO.BookingDTO;
import com.kamil.BookingSystem.Entity.Booking;
import com.kamil.BookingSystem.Entity.Client;
import com.kamil.BookingSystem.Entity.Hotel;
import com.kamil.BookingSystem.Exceptions.BookingDoesntExistsException;
import com.kamil.BookingSystem.Exceptions.ClientDoesntExistsException;
import com.kamil.BookingSystem.Exceptions.HotelDoesntExistsException;
import com.kamil.BookingSystem.Mappers.BookingMapper;
import com.kamil.BookingSystem.Repositories.BookingRepository;
import com.kamil.BookingSystem.Repositories.ClientRepository;
import com.kamil.BookingSystem.Repositories.HotelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final ClientRepository clientRepository;
    private final HotelRepository hotelRepository;

    @Transactional
    public BookingDTO addBooking(BookingBody bookingBody, Long clientId, Long hotelId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ClientDoesntExistsException("Client with given ID doesn't exist "));
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new HotelDoesntExistsException("Given hotel doesn't exist"));
        Booking booking = Booking.builder()
                .client(client)
                .hotel(hotel)
                .startsAt(bookingBody.getStartsAt())
                .endsAt(bookingBody.getEndsAt())
                .build();
        booking = bookingRepository.save(booking);
        client.addBooking(booking);
        hotel.addBooking(booking);
        clientRepository.save(client);
        hotelRepository.save(hotel);
        return BookingMapper.DTOMapper(booking);
    }

    @Transactional(readOnly = true)
    public List<BookingDTO> getAllBookings() {
        return bookingRepository.findAll()
                .stream()
                .map(BookingMapper::DTOMapper)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<BookingDTO> getBookingsOfAClient(Long clientId) {
        return bookingRepository.getAllBookingsOfClient(clientId)
                .stream()
                .map(BookingMapper::DTOMapper)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<BookingDTO> getBookingsOfAHotel(Long hotelId) {
        return bookingRepository.getAllBookingsOfHotel(hotelId)
                .stream()
                .map(BookingMapper::DTOMapper)
                .collect(Collectors.toList());
    }

    @Transactional
    public BookingDTO removeBooking(Long bookingId) {
        BookingDTO bookingDTO;
        if (bookingRepository.findById(bookingId).isPresent()) {
           bookingDTO = BookingMapper.DTOMapper(bookingRepository.getById(bookingId));
           bookingRepository.deleteById(bookingId);
        } else {
            throw new BookingDoesntExistsException("Booking with given id doesn't exists");
        }
        return bookingDTO;
     }



}
