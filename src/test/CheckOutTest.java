package test;

import ParkingApplication.CheckOut;
import ParkingApplication.Ticket;
import ParkingApplication.strategy.LostTicketStrategy;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalTime;

import static org.junit.Assert.*;

public class CheckOutTest {
    CheckOut checkOut;
    Ticket ticketA;
    Ticket ticketB;

    @Before
    public void setUp() throws Exception {
        checkOut = new CheckOut();
        ticketA = new Ticket(LocalTime.of(3,0), new LostTicketStrategy());
        ticketA.setCheckOutTime(LocalTime.of(4, 1));

    }

    @Test
    public void calculateHours() {

    }

    @Test
    public void calculateMinutes() {
        assertEquals(1, checkOut.calculateMinutes(ticketA));



    }
}