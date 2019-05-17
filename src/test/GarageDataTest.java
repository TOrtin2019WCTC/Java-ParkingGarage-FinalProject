package test;

import ParkingApplication.GarageData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GarageDataTest {

    int totalCheckIns;
    double totalCheckOutFees;
    int totalLostTickets;
    double totalLostTicketFees;
    int totalSpecialEventTickets;
    double totalSpecialEventFees;

    @Before
    public void setUp(){
        //GarageData garageData = GarageData.INSTANCE;

        totalCheckIns = 1;
        totalCheckOutFees = 1.00;
        totalLostTickets = 1;
        totalLostTicketFees = 1.00;
        totalSpecialEventTickets = 1;
        totalSpecialEventFees = 1.00;
    }

    @Test
    public void TestGetTotalCheckInsEquals1() {
        GarageData.INSTANCE.addTotalCheckIns();

        assertEquals(1, GarageData.INSTANCE.getTotalCheckIns());
    }

    @Test
    public void TestAddTotalCheckInsEquals2() {
        totalCheckIns++;

        assertEquals(2, totalCheckIns);
    }

    @Test
    public void getTotalCheckOutFees() {
        assertEquals(1.00, totalCheckOutFees,0);
    }

    @Test
    public void addTotalCheckOutFees() {
        totalCheckOutFees += 1.00;

        assertEquals(2.00, totalCheckOutFees,0);
    }

    @Test
    public void getTotalLostTickets() {
        assertEquals(1,totalLostTickets);
    }

    @Test
    public void addTotalLostTickets() {
        totalLostTickets++;

        assertEquals(2, totalLostTickets);
    }

    @Test
    public void getTotalLostTicketFees() {
        assertEquals(1.00,totalLostTicketFees,0);
    }

    @Test
    public void addTotalLostTicketFees() {
        totalLostTicketFees += 1.00;

        assertEquals(2.00, totalLostTicketFees, 0);
    }

    @Test
    public void getTotalFees() {
        assertEquals(3.00, totalLostTicketFees + totalSpecialEventFees + totalCheckOutFees, 0);
    }

    @Test
    public void getTotalSpecialEventTickets() {
        assertEquals(1, totalSpecialEventTickets);
    }

    @Test
    public void addTotalSpecialEventFees() {
        totalSpecialEventFees += 1.00;

        assertEquals(2.00, totalSpecialEventFees, 0);
    }

    @Test
    public void addTotalSpecialEventTickets() {
        totalSpecialEventTickets++;

        assertEquals(2, totalSpecialEventTickets);
    }

    @Test
    public void getTotalSpecialEventFees() {
        assertEquals(1.00, totalSpecialEventFees,0);
    }


}