package com.msvc.hotel.services;

import com.msvc.hotel.entities.Hotel;
import com.msvc.hotel.repositories.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImp implements HotelService {

    private final HotelRepository hotelRepository;

    public HotelServiceImp(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel findById(String id) {
        //TODO: @odprz implementar excepcion
        // return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El id " + id + " no existe"));
        return hotelRepository.findById(id).orElse(null);
    }

    @Override
    public Hotel save(Hotel hotel) {

        String randomId = UUID.randomUUID().toString();
        hotel.setId(randomId);
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel update(String id, Hotel hotel) {

        Hotel hotelUpdate = findById(id);
        if(hotelUpdate != null) {
            hotelUpdate.setNombre(hotel.getNombre());
            hotelUpdate.setInformacion(hotel.getInformacion());
            hotelUpdate.setUbicacion(hotel.getUbicacion());

            return hotelRepository.save(hotelUpdate);
        }
        //TODO: @odprz implementar excepcion no existe
        return null;
    }

    @Override
    public void delete(String id) {
        Hotel hotel = findById(id);
        if(hotel != null) {
            hotelRepository.delete(hotel);
        }
        //TODO: @odprz implementar excepcion no existe
    }

}
