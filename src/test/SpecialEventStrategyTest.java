package test;

import ParkingApplication.strategy.SpecialEventStrategy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpecialEventStrategyTest {

    SpecialEventStrategy strategy;

    @Before
    public void setUp() throws Exception {
        strategy = new SpecialEventStrategy();
    }

    @Test
    public void TestGetFeeEqualsTwenty() {
        double fee = strategy.getFee();

        assertEquals(20.00, fee, 0);
    }
}