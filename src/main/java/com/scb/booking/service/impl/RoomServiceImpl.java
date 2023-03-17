package com.scb.booking.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scb.booking.model.Booking;
import com.scb.booking.model.Room;
import com.scb.booking.repo.BookingRepository;
import com.scb.booking.repo.RoomRepository;
import com.scb.booking.service.RoomService;
import com.scb.booking.utils.CustomException;
import com.scb.booking.utils.Errors;

@Service
public class RoomServiceImpl implements RoomService {

	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	@Autowired
	RoomRepository roomRepository;

	@Autowired
	BookingRepository bookingRepository;

	@Override
	public List<Room> getAvailableRooms(String bookingDate) {
		List<Room> roomsAvailable = null;
//		LocalDate date = LocalDate.parse(bookingDate, formatter);
		
		LocalDate date = null;
		List<Booking> bookings = null;
		try {
			date = LocalDate.parse(bookingDate, formatter);
			if(date != null)
				bookings = bookingRepository.findAllByBookingDate(date);
		} catch (Exception e) {
			throw new CustomException(Errors.INTERNAL_ERROR);
		}
		
		List<Room> rooms = roomRepository.findAll();
	
		List<String> roomNumbers = new ArrayList<>();
		if (bookings != null) {
			List<String> roomNumbersAvailable = bookings.stream().map(room -> room.getRoomNumber())
					.collect(Collectors.toList());
			roomNumbers.addAll(roomNumbersAvailable);
		}

		if (roomNumbers != null && !roomNumbers.isEmpty()) {
			roomsAvailable = rooms.stream().filter(r -> !roomNumbers.contains(r.getRoomNumber()))
					.collect(Collectors.toList());

		} else {
			roomsAvailable = rooms;
		}
		return roomsAvailable;
	}

}
