package seminar04.test;

import org.junit.jupiter.api.Test;
import seminar04.hotel.BookingService;
import seminar04.hotel.HotelService;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TestHotel {

    @Test
    public void testBookingService() {
        HotelService mockHotelService = mock(HotelService.class);
        when(mockHotelService.isRoomAvailable(100)).thenReturn(true);

        BookingService bookingService = new BookingService(mockHotelService);
        assertTrue(bookingService.bookRoom(100));
        verify(mockHotelService, times(1)).isRoomAvailable(100);
    }
}
