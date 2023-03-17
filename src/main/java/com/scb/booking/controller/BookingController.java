package com.scb.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scb.booking.model.Booking;
import com.scb.booking.model.Room;
import com.scb.booking.service.BookingService;
import com.scb.booking.service.RoomService;
import com.scb.booking.utils.BookingVo;

@RestController
@RequestMapping("/booking-manager")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@Autowired
	private RoomService roomService;

	@RequestMapping(value = "/rooms/getAvailableRooms", method = RequestMethod.GET)
	public List<Room> getRoom(@RequestParam String date) {
		return roomService.getAvailableRooms(date);
	}

	@RequestMapping(value = "/booking/create", method = RequestMethod.POST)
	public String create(@RequestBody BookingVo bookigDetails) {
		Booking b = bookingService.create(bookigDetails);
		return b.toString();
	}

	@RequestMapping(value = "/booking/getAllBookings", method = RequestMethod.GET)
	public List<Booking> getAllBookingsByGusetName(@RequestParam String guestName) {
		return bookingService.getAllBookingsByGusetName(guestName);
	}
	

}
