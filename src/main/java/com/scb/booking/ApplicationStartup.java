package com.scb.booking;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.scb.booking.model.Room;
import com.scb.booking.repo.RoomRepository;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

	@Autowired
	RoomRepository roomRepository;

	@Value("${booking.rooms.count}")
	private String roomsCount;

	@Value("${booking.available.days}")
	private String validity;

	@Override
	public void onApplicationEvent(final ApplicationReadyEvent event) {
		Integer roomsCountVal = Integer.valueOf(roomsCount);
		Integer validityVal = Integer.valueOf(validity);
		for (int initialRoomNumber = 1; initialRoomNumber <= roomsCountVal; initialRoomNumber++) {
			System.out.println("R" + String.format("%0" + roomsCount.length() + "d", initialRoomNumber));
			publishAvailableRooms("R" + String.format("%0" + roomsCount.length() + "d", initialRoomNumber),
					LocalDate.now().plusDays(validityVal));
		}

	}

	private void publishAvailableRooms(String roomNumber, LocalDate availableDate) {
		Room room = new Room();
		room.setRoomNumber(roomNumber);
		room.setBookingAvailableUntil(availableDate);
		roomRepository.save(room);
	}
}