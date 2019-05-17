package test;

import ParkingApplication.CalculateFees;
import ParkingApplication.PricesAndFees;
import ParkingApplication.Ticket;
import ParkingApplication.strategy.MinMaxTicketStrategy;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;

import static org.junit.Assert.*;

public class MinMaxTicketStrategyTest {
    MinMaxTicketStrategy strategy;
    Ticket ticket;


    @Before
    public void setUp() throws Exception {
        strategy = new MinMaxTicketStrategy();
        ticket = new Ticket(LocalTime.of(1,0), strategy);

    }

    @Test
    public void TestGetFeeEqualsZero() {
        double fee = strategy.getFee();

        assertEquals(0, fee, 0);

    }

    @Test
    public void TestMinimumFeeCharged(){
        ticket.setCheckOutTime(LocalTime.of(1,1));

        assertEquals(PricesAndFees.MINIMUM_FEE, CalculateFees.calculateFees(ticket), 0);
    }

    @Test
    public void TestMaximumFeeCharged(){
        ticket.setCheckOutTime(LocalTime.of(19,0));

        assertEquals(PricesAndFees.MAX_FEE, CalculateFees.calculateFees(ticket), 0);
    }

    @Test
    public void TestPerHourCharged(){
        ticket.setCheckOutTime(LocalTime.of(5,0));

        assertEquals( 7 ,CalculateFees.calculateFees(ticket), 0);
    }
}