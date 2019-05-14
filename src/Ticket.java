import java.io.Serializable;
import java.time.LocalTime;
import java.util.Random;

public class Ticket implements GenerateTicketID, Serializable {

    private int vehicleID;
    private LocalTime checkInTime;
    private LocalTime checkOutTime;
    FeeStrategy feeStrategy;

    public Ticket(LocalTime checkInTime, FeeStrategy feeStrategy){
        this.vehicleID = generateID();
        this.checkInTime = checkInTime;
        this.feeStrategy = feeStrategy;

        System.out.println("Vehicle ID " + this.vehicleID + " Checked in");

    }

    public Ticket(){};


    @Override
    public int generateID() {
       int newVehicleID = (int) (Math.random() * (500 - 1) + 1);

       return newVehicleID;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public void setCheckOutTime(LocalTime checkOutTime){
        this.checkOutTime = checkOutTime;
    }

    public LocalTime getCheckInTime(){
        return checkInTime;
    }
    public LocalTime getCheckOutTime(){
        return checkOutTime;
    }
    public void setCheckInTime(LocalTime checkInTime){

        this.checkInTime = checkInTime;
    }

    public FeeStrategy getFeeStrategy(){
        return this.feeStrategy;
    }

}
