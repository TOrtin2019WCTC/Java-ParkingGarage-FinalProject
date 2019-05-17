package ParkingApplication;

import ParkingApplication.factory.ReceiptFactory;
import ParkingApplication.factory.ReceiptFactoryImpl;
import ParkingApplication.receipt.Receipt;
import ParkingApplication.strategy.LostTicketStrategy;


import java.time.Duration;
import java.time.LocalTime;
import java.util.Random;

public class CheckOut implements GenerateRandomCheckOutTime {

    Ticket ticket;
    ReceiptFactory factory = new ReceiptFactoryImpl();

    public CheckOut(){

    }
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


    public static long calculateHours(Ticket ticket) {
        long hours = 0;

        hours = Duration.between(ticket.getCheckInTime(), ticket.getCheckOutTime()).toHours();

        return hours;
    }


   public static long calculateMinutes(Ticket ticket) {
        long minutes = 0;

        minutes = Duration.between(ticket.getCheckInTime(), ticket.getCheckOutTime()).toMinutes();

        while (minutes >= 60) {
            minutes -= 60;
        }
        return minutes;
    }


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
