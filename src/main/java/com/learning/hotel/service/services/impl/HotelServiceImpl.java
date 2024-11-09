package com.learning.hotel.service.services.impl;

import com.learning.hotel.service.entity.Hotel;
import com.learning.hotel.service.exceptions.ResourceNotFoundException;
import com.learning.hotel.service.repositories.HotelRepository;
import com.learning.hotel.service.services.HotelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;

    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public Hotel create(Hotel hotel) {
        final var hotelId = UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel getHotel(String id) {
        return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel not found with id: " + id));
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }
}
