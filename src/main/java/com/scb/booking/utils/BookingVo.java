package com.scb.booking.utils;

import java.io.Serializable;


public class BookingVo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	String guestName;
	String roomNumber;
	String bookingDate;
    
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	
	

}
