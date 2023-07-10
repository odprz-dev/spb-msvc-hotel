package com.msvc.hotel.services;

import com.msvc.hotel.entities.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelService {

    List<Hotel> findAll();

    Hotel findById(String id);

    Hotel save(Hotel hotel);

    Hotel update(String id, Hotel hotel);

    void delete(String id);


}
