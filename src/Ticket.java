import java.time.LocalTime;
import java.util.Random;

public class Ticket implements GenerateTicketID,GenerateRandomCheckInTime{

    private int vehicleID;
    private SingletonParkedCarsList garage;
    private LocalTime checkInTime;


    public Ticket(){
        this.vehicleID = generateID();
        this.garage = SingletonParkedCarsList.INSTANCE;
        this.checkInTime = generateCheckInTime();
        garage.addCar(this);
    }

    @Override
    public int generateID() {
       int newVehicleID = (int) (Math.random() * (500 - 1) + 1);

       return newVehicleID;
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

    public int getVehicleID() {
        return vehicleID;
    }

    public LocalTime getCheckInTime() {
        return checkInTime;
    }
}
