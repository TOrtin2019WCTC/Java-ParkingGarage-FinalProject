package ParkingApplication.receipt;

import ParkingApplication.GarageController;
import ParkingApplication.GarageData;
import ParkingApplication.Ticket;
import ParkingApplication.strategy.LostTicketStrategy;


import java.text.NumberFormat;

/**
 *
 * class is subclass of Receipt superclass and creates lost ticket receipt
 *
 * @author Tim Ortin
 */

public class LostTicketReceipt extends Receipt {

    Ticket ticket;

    /**
     * Method creates instance of LostTicketReceipt
     * @param ticket Ticket object
     */
    public LostTicketReceipt(Ticket ticket){

        this.ticket = ticket;
            GarageData.INSTANCE.addTotalLostTickets();
           GarageData.INSTANCE.addTotalLostTicketFees(new LostTicketStrategy().getFee());


        }


    /**
     * Method prints lost ticket receipt for a ticket with no check-in to console
     */
    public void printNoCheckInLostTicketReceipt(){
        NumberFormat numberFormatter = NumberFormat.getCurrencyInstance();
        System.out.println("\n\n\t" + GarageController.garageName);
        System.out.println("\n\t===============================");
        System.out.println("\n\n\tLost Ticket");
        System.out.println("\t" + numberFormatter.format(new LostTicketStrategy().getFee()));
        System.out.println("\t------------------------------\n\n");

    }

    /**
     * method prints lost ticket receipt to console
     */
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
