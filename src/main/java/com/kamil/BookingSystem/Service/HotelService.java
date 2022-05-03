package com.kamil.BookingSystem.Service;

import com.kamil.BookingSystem.DTO.HotelDTO;
import com.kamil.BookingSystem.Entity.Hotel;
import com.kamil.BookingSystem.Exceptions.HotelAlreadyExistsException;
import com.kamil.BookingSystem.Exceptions.HotelDoesntExistsException;
import com.kamil.BookingSystem.Mappers.HotelMapper;
import com.kamil.BookingSystem.Repositories.HotelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;


    public List<HotelDTO> getAllHotels() {
       return hotelRepository.findAll()
               .stream()
               .map(HotelMapper::DTOMapper)
               .collect(Collectors.toList());
    }

    public List<HotelDTO> getAllHotelInLocation(String location) {
        return hotelRepository.findAll()
                .stream()
                .filter(h -> location.equals(h.getLocation()))
                .map(HotelMapper::DTOMapper)
                .collect(Collectors.toList());
    }

    public HotelDTO addHotel(HotelDTO hotelDTO) {
        if(hotelRepository.selectExistsByNameAndLocation(hotelDTO.getName(),hotelDTO.getLocation()))
        {
            throw new HotelAlreadyExistsException("Given hotel is already in database");
        }
       Hotel hotel = hotelRepository.save(HotelMapper.hotelMapper(hotelDTO));
       hotelDTO.setId(hotel.getId());
       return hotelDTO;
    }
    
    public HotelDTO RemoveHotel(HotelDTO hotelDTO) {
        if(hotelRepository.selectExistsByNameAndLocation(hotelDTO.getName(), hotelDTO.getLocation())) {
            hotelRepository.deleteById(hotelDTO.getId());
        } else {
            throw new HotelDoesntExistsException("Given hotel doesn't exists in database");
        }
        return hotelDTO;
    }


}
