import java.text.NumberFormat;
import java.util.Random;

public class LostTicketReceipt extends Receipt {

    Ticket ticket;

    public LostTicketReceipt(){
        Random random = new Random();
        if (GarageController.list.tickets.size() > 0){
            try{
                int index = random.nextInt(GarageController.list.tickets.size());
                this.ticket = GarageController.list.tickets.get(index);
                GarageController.list.tickets.remove(this.ticket);
                GarageController.garageData.totalLostTickets ++;
                GarageController.garageData.totalLostTicketFees += new LostTicketStrategy().getFee();
                GarageController.garageData.totalFees += new LostTicketStrategy().getFee();

            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }else {
            printNoCheckInLostTicketReceipt();
            GarageController.garageData.totalLostTickets ++;
            GarageController.garageData.totalLostTicketFees += new LostTicketStrategy().getFee();
            GarageController.garageData.totalFees += new LostTicketStrategy().getFee();


        }


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
    void printReceipt() {
        NumberFormat numberFormatter = NumberFormat.getCurrencyInstance();
        System.out.println("\n\n\t" + GarageController.garageName);
        System.out.println("\n\t===============================");
        System.out.println("\n\treceipt for vehicle id " + this.ticket.getVehicleID());
        System.out.println("\n\n\tLost Ticket");
        System.out.println("\t" + numberFormatter.format(new LostTicketStrategy().getFee()));
        System.out.println("\t------------------------------\n\n");
    }
}
