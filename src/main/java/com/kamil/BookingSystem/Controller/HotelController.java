package com.kamil.BookingSystem.Controller;




import com.kamil.BookingSystem.DTO.HotelDTO;
import com.kamil.BookingSystem.Service.HotelService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/hotel")
@AllArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    @PostMapping("/add")
    public ResponseEntity<HotelDTO> addHotel(@RequestBody HotelDTO hotelDTO) {
        return new ResponseEntity<>(hotelService.addHotel(hotelDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{hotelLocation}")
    public ResponseEntity<List<HotelDTO>> getHotel(@PathVariable String hotelLocation) {
        return new ResponseEntity<>(hotelService.getAllHotelInLocation(hotelLocation), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<HotelDTO>> getAllHotels() {
        return new ResponseEntity<>(hotelService.getAllHotels(), HttpStatus.OK);
    }

    @DeleteMapping("/{hotelId}")
    public ResponseEntity<String> deleteHotel(@PathVariable Long hotelId) {
        return new ResponseEntity<>(hotelService.removeHotel(hotelId),HttpStatus.OK);
    }
}
