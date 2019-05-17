package ParkingApplication;

import ParkingApplication.factory.ReceiptFactory;
import ParkingApplication.factory.ReceiptFactoryImpl;
import ParkingApplication.receipt.Receipt;
import ParkingApplication.strategy.LostTicketStrategy;


import java.time.Duration;
import java.time.LocalTime;
import java.util.Random;

/**
 * Class handles all operations for vehicle check out and implements GenerateRandomCheckOutTime Interface
 * @author Tim Ortin
 */
public class CheckOut implements GenerateRandomCheckOutTime {

    Ticket ticket;
    ReceiptFactory factory = new ReceiptFactoryImpl();

    /**
     * Method creates instance of CheckOut
     */
    public CheckOut(){

    }

    /**
     * Implemented method that generates random check out time
     * @return LocalTime returns a check out time
     */
    @Override
    public LocalTime generateCheckOutTime() {
        LocalTime checkOutTime = null;
        Random random = new Random();
        int hours = 0;
        int minutes = 0;

        hours = random.nextInt(11) + 13;
        minutes = random.nextInt(59);

        checkOutTime = LocalTime.of(hours, minutes);

        return checkOutTime;
    }

    /**
     * Method calculates duration between vehicle check in and check out
     * @param ticket Ticket object
     * @return long returns total number of hours parked
     */
    public static long calculateHours(Ticket ticket) {
        long hours = 0;

        hours = Duration.between(ticket.getCheckInTime(), ticket.getCheckOutTime()).toHours();

        return hours;
    }

    /**
     * Method returns leftover minutes between vehicle check in and check out
     * @param ticket Ticket object
     * @return long returns any remaining minutes less than 60
     */
   public static long calculateMinutes(Ticket ticket) {
        long minutes = 0;

        minutes = Duration.between(ticket.getCheckInTime(), ticket.getCheckOutTime()).toMinutes();

        while (minutes >= 60) {
            minutes -= 60;
        }
        return minutes;
    }


    /**
     * Method gets random ticket out of the parked cars array list and uses the fee strategy factory to generate a receipt
     * if ticket is not lost
     */
    public void checkOut(){
        Receipt receipt;
        Random random = new Random();
        try{
            if (SingletonParkedCarsList.INSTANCE.numCars() > 0){
                int index = random.nextInt(SingletonParkedCarsList.INSTANCE.numCars());
                this.ticket = SingletonParkedCarsList.INSTANCE.getTicket(index);
                this.ticket.setCheckOutTime(generateCheckOutTime());

               receipt = factory.make(this.ticket);
               receipt.printReceipt();
               SingletonParkedCarsList.INSTANCE.removeCar(this.ticket);

            }else {
                System.out.println("Perhaps you snuck in, there are no record of vehicles currently parked.");
                System.out.println("Generating lost ticket receipt....");
                receipt = factory.make(null);
                receipt.printReceipt();
            }


        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * method gets random ticket out of parked cars array list, generates receipt if the lost ticket option is selected
     */
    public void lostTicket(){
        Receipt receipt;
        Random random = new Random();
        try {
            if (SingletonParkedCarsList.INSTANCE.numCars() > 0) {
                int index = random.nextInt(SingletonParkedCarsList.INSTANCE.numCars());
                this.ticket = SingletonParkedCarsList.INSTANCE.getTicket(index);
                this.ticket.setFeeStrategy(new LostTicketStrategy());
                receipt = factory.make(this.ticket);
                receipt.printReceipt();

            }else{
                receipt = factory.make(null);
                receipt.printReceipt();

            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

}
