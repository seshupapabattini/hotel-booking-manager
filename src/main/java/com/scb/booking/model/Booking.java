package com.scb.booking.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Booking implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue
    private int id;
	
	String guestName;
	String roomNumber;
	LocalDate bookingDate;
    
    /*** In case having any issues with lombok **/
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	

    

	
//	public Booking(String guestName, String roomNumber, Date bookingDate) {
//		this.guestName = guestName;
//		this.roomNumber = roomNumber;
//		this.bookingDate = bookingDate;
//	}
//
//
//
//	@Override
//	public String toString() {
//		return "Booking [guestName=" + guestName + ", roomNumber=" + roomNumber + ", bookingDate=" + bookingDate
//				+ "]";
//	}

}
