package test;

import ParkingApplication.strategy.LostTicketStrategy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LostTicketStrategyTest {

    LostTicketStrategy strategy;
    @Before
    public void setUp() throws Exception {
        strategy = new LostTicketStrategy();
    }

    @Test
    public void TestGetFeeEqualsTwentyFive() {
        double fee = strategy.getFee();

        assertEquals(25.00, fee, 0);
    }
}