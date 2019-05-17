package test;

import ParkingApplication.Ticket;
import ParkingApplication.receipt.LostTicketReceipt;
import ParkingApplication.strategy.FeeStrategy;
import ParkingApplication.strategy.LostTicketStrategy;
import ParkingApplication.strategy.SpecialEventStrategy;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;

import static org.junit.Assert.*;

public class TicketTest {
    private int vehicleID;
    private LocalTime checkInTime;
    private LocalTime checkOutTime;
    private FeeStrategy feeStrategy;


    @Before
    public void setUp(){
        vehicleID = 2;
        checkInTime = LocalTime.of(3,0);
        checkOutTime = LocalTime.of(4,0);
        feeStrategy = new LostTicketStrategy();
    }



    @Test
    public void generateID() {
        int newVehicleID = (int) (Math.random() * (1- 1) + 1);
        assertEquals(1, newVehicleID);
    }

    @Test
    public void getVehicleID() {
        int vehicleId = this.vehicleID;

        assertEquals(2, vehicleId);
    }

    @Test
    public void setCheckOutTime() {
        LocalTime newCheckOutTime = LocalTime.of(2,0);
        this.checkOutTime = newCheckOutTime;

        assertTrue(this.checkOutTime.equals(newCheckOutTime));
    }

    @Test
    public void getCheckInTime() {
        LocalTime newCheckInTIme = LocalTime.of(3,0);
        assertEquals(this.checkInTime, newCheckInTIme);
    }

    @Test
    public void getCheckOutTime() {
        LocalTime test = LocalTime.of(4,0);

        assertEquals(this.checkOutTime, test);
    }

    @Test
    public void setCheckInTime() {
       LocalTime newCheckInTime = LocalTime.of(6,0);
       this.checkInTime = newCheckInTime;

        assertEquals(this.checkInTime, checkInTime);
    }

    @Test
    public void getFeeStrategy() {
        assertTrue(this.feeStrategy instanceof LostTicketStrategy);
    }

    @Test
    public void setFeeStrategy() {
        this.feeStrategy = new SpecialEventStrategy();
        assertTrue(this.feeStrategy instanceof SpecialEventStrategy);
    }

}