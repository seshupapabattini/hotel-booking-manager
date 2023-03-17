package com.scb.booking.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scb.booking.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {


    List<Booking> findAllByGuestName(String guestName);
    
    List<Booking> findAllByBookingDate(LocalDate bookingDate);
//    Booking findByBookingDateAndRoomNumber(LocalDate guestName, String roomNumber);
    boolean existsByBookingDateAndRoomNumber(LocalDate guestName, String roomNumber);



}
