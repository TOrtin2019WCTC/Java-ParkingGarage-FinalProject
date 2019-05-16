package ParkingApplication;

import ParkingApplication.strategy.FeeStrategy;

import java.time.LocalTime;
import java.util.Random;

public class CheckIn implements GenerateRandomCheckInTime {

  //
    Ticket ticket;

    public CheckIn(FeeStrategy strategy){

        Ticket ticket = new Ticket(generateCheckInTime(), strategy );
       GarageController.list.addCar(ticket);


    }

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
