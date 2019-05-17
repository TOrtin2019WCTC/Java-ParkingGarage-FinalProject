package ParkingApplication;

import ParkingApplication.strategy.FeeStrategy;

import java.io.Serializable;
import java.time.LocalTime;

/**
 * class creates Ticket objects and implements GenerateTicketID and Serializable Interfaces
 * @author Tim Ortin
 */
public class Ticket implements GenerateTicketID, Serializable {

    private int vehicleID;
    private LocalTime checkInTime;
    private LocalTime checkOutTime;
    private FeeStrategy feeStrategy;

    /**
     * method constructs a Ticket object and sets values of vehicleID, checkInTime and feeStrategy.
     * method also prints out confirmation that vehicle has checked in.
     * @param checkInTime LocalTime time of vehicle check in
     * @param feeStrategy FeeStrategy fee strategy to be used
     */
    public Ticket(LocalTime checkInTime, FeeStrategy feeStrategy){
        this.vehicleID = generateID();
        this.checkInTime = checkInTime;
        this.feeStrategy = feeStrategy;

        System.out.println("Vehicle ID " + this.vehicleID + " Checked in");

    }


    /**
     * implemented method generates random vehicle id between 1 and 500
     * @return int returns a vehicle id
     */
    @Override
    public int generateID() {
       int newVehicleID = (int) (Math.random() * (500 - 1) + 1);

       return newVehicleID;
    }

    /**
     * method returns the vehicle id of Ticket object
     * @return int returns the vehicle id
     */
    public int getVehicleID() {
        return vehicleID;
    }

    /**
     * method sets the check out time for Ticket object
     * @param checkOutTime LocalTime time of check in
     */
    public void setCheckOutTime(LocalTime checkOutTime){
        this.checkOutTime = checkOutTime;
    }

    /**
     * method returns the Ticket object check in time
     * @return LocalTime returns time of Ticket check in
     */
    public LocalTime getCheckInTime(){
        return checkInTime;
    }

    /**
     * method returns the Ticket object check out time
     * @return LocalTime returns time of Ticket check out
     */
    public LocalTime getCheckOutTime(){
        return checkOutTime;
    }

    /**
     * method sets the check in time of Ticket object
     * @param checkInTime LocalTime time of ticket check in
     */
    public void setCheckInTime(LocalTime checkInTime){

        this.checkInTime = checkInTime;
    }

    /**
     * returns the fee strategy of Ticket object
     * @return FeeStrategy fee strategy of ticket object
     */
    public FeeStrategy getFeeStrategy(){
        return this.feeStrategy;
    }

    /**
     * method sets the fee strategy for Ticket object
     * @param feeStrategy FeeStrategy fee strategy to be used by Ticket object
     */
    public void setFeeStrategy(FeeStrategy feeStrategy){
        this.feeStrategy = feeStrategy;
    }

}
