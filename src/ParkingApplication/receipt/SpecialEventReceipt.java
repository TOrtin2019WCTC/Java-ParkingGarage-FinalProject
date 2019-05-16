package ParkingApplication.receipt;

import ParkingApplication.GarageController;
import ParkingApplication.GarageData;
import ParkingApplication.SingletonParkedCarsList;
import ParkingApplication.Ticket;
import ParkingApplication.receipt.Receipt;
import ParkingApplication.strategy.LostTicketStrategy;
import ParkingApplication.strategy.SpecialEventStrategy;

import java.text.NumberFormat;
import java.util.Random;

public class SpecialEventReceipt extends Receipt {

    Ticket ticket;

    public SpecialEventReceipt(Ticket ticket){
        this.ticket = ticket;

            GarageData.INSTANCE.addTotalSpecialEventTickets();
            GarageData.INSTANCE.addTotalSpecialEventFees(new SpecialEventStrategy().getFee());



    }


    @Override
    public void printReceipt() {
        NumberFormat numberFormatter = NumberFormat.getCurrencyInstance();
        System.out.println("\n\n\t" + GarageController.garageName);
        System.out.println("\n\t===============================");
        System.out.println("\n\treceipt for vehicle id " + this.ticket.getVehicleID());
        System.out.println("\n\n\tSpecial Event");
        System.out.println("\t" + numberFormatter.format(new SpecialEventStrategy().getFee()));
        System.out.println("\t------------------------------\n\n");
    }
}
