package ParkingApplication.receipt;

import ParkingApplication.GarageController;
import ParkingApplication.GarageData;
import ParkingApplication.Ticket;
import ParkingApplication.strategy.LostTicketStrategy;


import java.text.NumberFormat;


public class LostTicketReceipt extends Receipt {

    Ticket ticket;

    public LostTicketReceipt(Ticket ticket){

        this.ticket = ticket;
            GarageData.INSTANCE.addTotalLostTickets();
           GarageData.INSTANCE.addTotalLostTicketFees(new LostTicketStrategy().getFee());


        }




    public void printNoCheckInLostTicketReceipt(){
        NumberFormat numberFormatter = NumberFormat.getCurrencyInstance();
        System.out.println("\n\n\t" + GarageController.garageName);
        System.out.println("\n\t===============================");
        System.out.println("\n\n\tLost Ticket");
        System.out.println("\t" + numberFormatter.format(new LostTicketStrategy().getFee()));
        System.out.println("\t------------------------------\n\n");

    }

    @Override
    public void printReceipt() {
        if(ticket == null){
            printNoCheckInLostTicketReceipt();
        }else{
            NumberFormat numberFormatter = NumberFormat.getCurrencyInstance();
            System.out.println("\n\n\t" + GarageController.garageName);
            System.out.println("\n\t===============================");
            System.out.println("\n\treceipt for vehicle id " + this.ticket.getVehicleID());
            System.out.println("\n\n\tLost Ticket");
            System.out.println("\t" + numberFormatter.format(new LostTicketStrategy().getFee()));
            System.out.println("\t------------------------------\n\n");
        }

    }
}
