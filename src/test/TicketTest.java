package test;

import ParkingApplication.Ticket;
import ParkingApplication.strategy.FeeStrategy;
import ParkingApplication.strategy.LostTicketStrategy;
import ParkingApplication.strategy.SpecialEventStrategy;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;

import static org.junit.Assert.*;

public class TicketTest {

    Ticket ticket;
    @Before
    public void setUp() throws Exception {
        ticket = new Ticket(LocalTime.of(3,0), new LostTicketStrategy());

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void TestGenerateIDGreaterThan0LessThanEqualTo500() {
        int min = 0;
        int max = 500;

        for (int i = 0; i < 10; i++){

            assertTrue("Number less than zero", ticket.generateID() > min);
            assertTrue("Number greater than 500", ticket.generateID() <= max);

        }

    }

    @Test
    public void TestGetVehicleIDGreaterThan0LessThanEqualTo500() {
        int min = 0;
        int max = 500;

        assertTrue("Number less than zero", ticket.getVehicleID() > min);
        assertTrue("Number greater than 500", ticket.getVehicleID() <= max);
    }

    @Test
    public void TestSetCheckOutTimeTo4OClock() {
        LocalTime testTime = LocalTime.of(2,0);
        ticket.setCheckOutTime(testTime);

        assertEquals(testTime,ticket.getCheckOutTime());

    }

    @Test
    public void TestGetCheckInTimeEquals3OClock() {
        LocalTime time = LocalTime.of(3,0);
        assertEquals(time, ticket.getCheckInTime());
    }

    @Test
    public void TestGetCheckOutTimeOf5OClock() {
        ticket.setCheckOutTime(LocalTime.of(5,0));

        LocalTime time = LocalTime.of(5,0);
       assertEquals(time, ticket.getCheckOutTime());
    }

    @Test
    public void TestSetCheckInTimeTo6OClock() {
        ticket.setCheckInTime(LocalTime.of(6,0));

        LocalTime time = LocalTime.of(6,0);

        assertEquals(time, ticket.getCheckInTime());

    }

    @Test
    public void TestGetFeeStrategyIsLostTicketStrategy() {

        assertTrue("fee strategy is lost ticket strategy", ticket.getFeeStrategy() instanceof LostTicketStrategy);

    }

    @Test
    public void TestSetFeeStrategyToSpecialEventStrategy() {
        ticket.setFeeStrategy(new SpecialEventStrategy());

        assertTrue(ticket.getFeeStrategy() instanceof SpecialEventStrategy);
    }
}