package com.scb.booking;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.scb.booking.model.Booking;
import com.scb.booking.repo.BookingRepository;
import com.scb.booking.service.impl.BookingServiceImpl;
import com.scb.booking.utils.BookingVo;
import com.scb.booking.utils.CustomException;
import com.scb.booking.utils.Errors;

@ExtendWith(SpringExtension.class)
public class BookingServiceImplTest {
	

    @InjectMocks
    private BookingServiceImpl bookingService;

    @Mock
    private BookingRepository bookingRepository;
    
    
    @Test
    public void createBooking() {
    	BookingVo booking = new BookingVo();
		booking.setGuestName("Seshu");
		booking.setRoomNumber("R01");
		booking.setBookingDate("17-03-2023");
        when(bookingRepository.existsByBookingDateAndRoomNumber(any(), any())).thenReturn(false);
        bookingService.create(booking);
        ArgumentCaptor<Booking> captor = ArgumentCaptor.forClass(Booking.class);
        verify(bookingRepository).save(captor.capture());
        assertThat(captor.getValue().getRoomNumber()).isEqualTo(booking.getRoomNumber());
        assertThat(captor.getValue().getGuestName()).isEqualTo(booking.getGuestName());
    }
    
    
    @Test
    public void createDuplicateBooking() {
    	when(bookingRepository.existsByBookingDateAndRoomNumber(any(), any())).thenReturn(true);
        throwsError(() -> bookingService.create(new BookingVo()), Errors.INTERNAL_ERROR);
    }
    
    
    @Test
    public void findAllByGuestName(){
        when(bookingRepository.findAllByGuestName("Seshu")).thenReturn(Arrays.asList(new Booking()));
        List<Booking> res = bookingService.getAllBookingsByGusetName("Seshu");
        assertThat(res.size()).isEqualTo(1);
    }
    
    
    private void throwsError(ThrowableAssert.ThrowingCallable callable, Errors error) {
        assertThatThrownBy(callable)
                .isInstanceOf(CustomException.class)
                .hasFieldOrPropertyWithValue("error", error);
    }

}
