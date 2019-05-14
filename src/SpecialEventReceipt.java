import java.text.NumberFormat;
import java.util.Random;

public class SpecialEventReceipt extends Receipt {

    Ticket ticket;

    public SpecialEventReceipt(){
        Random random = new Random();
        try{
            int index = random.nextInt(GarageController.list.tickets.size());
            this.ticket = GarageController.list.tickets.get(index);
            GarageController.list.tickets.remove(this.ticket);
            GarageController.garageData.totalSpecialEventTickets ++;
            GarageController.garageData.totalSpecialEventFees += new SpecialEventStrategy().getFee();


        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


    @Override
    void printReceipt() {
        NumberFormat numberFormatter = NumberFormat.getCurrencyInstance();
        System.out.println("\n\n\t" + GarageController.garageName);
        System.out.println("\n\t===============================");
        System.out.println("\n\treceipt for vehicle id " + this.ticket.getVehicleID());
        System.out.println("\n\n\tSpecial Event");
        System.out.println("\t" + numberFormatter.format(new SpecialEventStrategy().getFee()));
        System.out.println("\t------------------------------\n\n");
    }
}
