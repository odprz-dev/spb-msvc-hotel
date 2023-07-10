package com.msvc.hotel.controllers;

import com.msvc.hotel.entities.Hotel;
import com.msvc.hotel.services.HotelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("api/v1/hotel")
public class HotelController {
    private final HotelService hotelService;

    HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("")
    public ResponseEntity<?> getHotels() {
        return ResponseEntity.ok(hotelService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getHotelById(@PathVariable String id) {
        return ResponseEntity.ok(hotelService.findById(id));
    }

    @PostMapping("")
    public ResponseEntity<?> postHotel(@RequestBody Hotel hotel) {

        Hotel result = hotelService.save(hotel);
        return ResponseEntity.created(URI.create("api/v1/hotel/" + result.getId())).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putHotel(@PathVariable String id, @RequestBody Hotel hotel) {
        return ResponseEntity.ok(hotelService.update(id, hotel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHotel(@PathVariable String id) {
        hotelService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
