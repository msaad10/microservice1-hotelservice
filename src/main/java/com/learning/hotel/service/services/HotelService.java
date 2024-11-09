package com.learning.hotel.service.services;

import com.learning.hotel.service.entity.Hotel;

import java.util.List;

public interface HotelService {
    Hotel create(Hotel hotel);
    Hotel getHotel(String id);
    List<Hotel> getAll();

}
