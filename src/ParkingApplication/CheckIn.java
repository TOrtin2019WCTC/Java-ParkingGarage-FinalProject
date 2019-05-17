package ParkingApplication;

import ParkingApplication.strategy.FeeStrategy;

import java.time.LocalTime;
import java.util.Random;

/**
 * class handles actions taken when vehicle checks in to garage
 * @author Tim Ortin
 */

public class CheckIn implements GenerateRandomCheckInTime {

    /**
     * Method creates instance of check in, creates new Ticket object
     * @param strategy FeeStrategy
     */
    public CheckIn(FeeStrategy strategy){

        Ticket ticket = new Ticket(generateCheckInTime(), strategy );
       GarageController.list.addCar(ticket);


    }

    /**
     * Method generates random check in time
     * @return LocalTime newCheckInTime
     */
    @Override
    public LocalTime generateCheckInTime() {
        Random random = new Random();
        int hours = 0;
        int minutes = 0;
        hours = random.nextInt(11 + 1 - 7) + 7;

        minutes = random.nextInt(59) + 1;
        LocalTime newCheckInTime = LocalTime.of(hours, minutes);
        return newCheckInTime;
    }
}
