package com.scb.booking.service;

import java.util.List;

import com.scb.booking.model.Room;

public interface RoomService {

	List<Room> getAvailableRooms(String date);

}
