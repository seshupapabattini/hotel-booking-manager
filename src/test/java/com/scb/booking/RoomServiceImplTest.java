package com.scb.booking;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.scb.booking.model.Room;
import com.scb.booking.repo.RoomRepository;
import com.scb.booking.service.impl.RoomServiceImpl;
import com.scb.booking.utils.CustomException;
import com.scb.booking.utils.Errors;

@ExtendWith(SpringExtension.class)
public class RoomServiceImplTest {

	@InjectMocks
	private RoomServiceImpl roomService;

	@Mock
	private RoomRepository roomRepository;

	@Test
	public void createRoom() {
		Room room = new Room();
		room.setRoomNumber("R01");
		room.setBookingAvailableUntil(LocalDate.now());
		roomRepository.save(room);
		ArgumentCaptor<Room> captor = ArgumentCaptor.forClass(Room.class);
		verify(roomRepository).save(captor.capture());
		assertThat(captor.getValue().getRoomNumber()).isEqualTo(room.getRoomNumber());
	}

	@Test
	public void getAvailableRooms() {
		when(roomRepository.findAll()).thenReturn(Arrays.asList(new Room()));
		throwsError(() ->  roomService.getAvailableRooms("17-03-2023"), Errors.INTERNAL_ERROR);
	}

	private void throwsError(ThrowableAssert.ThrowingCallable callable, Errors error) {
		assertThatThrownBy(callable).isInstanceOf(CustomException.class).hasFieldOrPropertyWithValue("error", error);
	}

}
