package test;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
       CheckOutTest.class,
        GarageDataTest.class,
        LostTicketStrategyTest.class,
        MinMaxTicketStrategyTest.class,
        TicketTest.class
})

public class TestSuite {

}
