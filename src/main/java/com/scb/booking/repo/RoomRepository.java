package com.scb.booking.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scb.booking.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

    Room findByRoomNumber(String roomNumber);

    List<Room> findAllByBookingDate(LocalDate bookingDate);



}
