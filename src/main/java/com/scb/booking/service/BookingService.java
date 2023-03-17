package com.scb.booking.service;

import java.util.List;

import com.scb.booking.model.Booking;
import com.scb.booking.utils.BookingVo;

public interface BookingService {

	Booking create(BookingVo BookingDetails);

	List<Booking> getAllBookingsByGusetName(String guestName);

}
