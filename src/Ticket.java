import java.time.LocalTime;
import java.util.Random;

public class Ticket implements GenerateTicketID{

    private int vehicleID;
    private SingletonParkedCarsList garage;
    private LocalTime checkInTime;


    public Ticket(LocalTime checkInTime){
        this.checkInTime = checkInTime;
        this.vehicleID = generateID();
        this.garage = SingletonParkedCarsList.INSTANCE;
    }

    @Override
    public int generateID() {
       int newVehicleID = (int) (Math.random() * (500 - 1) + 1);

       return newVehicleID;
    }


    public int getVehicleID() {
        return vehicleID;
    }

    public LocalTime getCheckInTime() {
        return checkInTime;
    }
}
