package com.scb.booking.model;

import java.io.Serializable;
import java.time.LocalDate;

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
public class Room implements Serializable {
	
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private int id;
    
	String roomNumber;
	LocalDate bookingDate;
	LocalDate bookingAvailableUntil;
	
	/*** In case having any issues with lombok **/
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public LocalDate getBookingAvailableUntil() {
		return bookingAvailableUntil;
	}
	public void setBookingAvailableUntil(LocalDate bookingAvailableUntil) {
		this.bookingAvailableUntil = bookingAvailableUntil;
	}


}
