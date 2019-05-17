package ParkingApplication.receipt;

import ParkingApplication.*;

import java.time.format.DateTimeFormatter;

/**
 * class is subclass of Receipt superclass
 * @author Tim Ortin
 */
public class NormalReceipt extends Receipt {

    Ticket ticket;

    /**
     * Method creates instance of normal receipt
     * @param ticket Ticket object
     */
    public NormalReceipt(Ticket ticket){
        this.ticket = ticket;
    }

    /**
     * Method prints normal receipt to console
     */
    @Override
    public void printReceipt() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("h:mm");
        System.out.println("\n\n\t" + GarageController.garageName);
        System.out.println("\n\t===============================");
        System.out.println("\n\tReceipt for vehicle id " + this.ticket.getVehicleID());

        System.out.println("\n\t" + CheckOut.calculateHours(this.ticket) + " hours "
                + CheckOut.calculateMinutes(this.ticket) + " minutes parked"
                + "\n\t" + fmt.format(this.ticket.getCheckInTime())
                + "am - " + fmt.format(this.ticket.getCheckOutTime()) + "pm");

        System.out.println("\n\t" + CurrencyFormatter.currencyFormatter(CalculateFees.calculateFees(this.ticket)));
        System.out.println("\n\t------------------------------\n\n");

      GarageData.INSTANCE.addTotalCheckOutFees(CalculateFees.calculateFees(this.ticket));
        GarageData.INSTANCE.addTotalCheckIns();
    }
}
