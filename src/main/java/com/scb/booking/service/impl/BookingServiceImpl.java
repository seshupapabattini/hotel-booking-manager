package com.scb.booking.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scb.booking.model.Booking;
import com.scb.booking.repo.BookingRepository;
import com.scb.booking.service.BookingService;
import com.scb.booking.utils.BookingVo;
import com.scb.booking.utils.CustomException;
import com.scb.booking.utils.Errors;

@Service
public class BookingServiceImpl implements BookingService {

	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	@Autowired
	BookingRepository bookingRepository;

	@Override
	public Booking create(BookingVo bookigDetails) {

		LocalDate date = null;
		try {
			date = LocalDate.parse(bookigDetails.getBookingDate(), formatter);
		} catch (Exception e) {
			throw new CustomException(Errors.INTERNAL_ERROR);
		}
		boolean bookings = bookingRepository.existsByBookingDateAndRoomNumber(date, bookigDetails.getRoomNumber());
		if (bookings) {
			throw new CustomException(Errors.INTERNAL_ERROR);
		} else {
			Booking booking = new Booking();
			booking.setGuestName(bookigDetails.getGuestName());
			booking.setRoomNumber(bookigDetails.getRoomNumber());
			booking.setBookingDate(date);
			return bookingRepository.save(booking);

		}
	}

	@Override
	public List<Booking> getAllBookingsByGusetName(String guestName) {
		return bookingRepository.findAllByGuestName(guestName);
	}

}
