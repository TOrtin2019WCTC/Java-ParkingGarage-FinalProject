import java.time.Duration;
import java.time.LocalTime;
import java.util.Random;

public class CheckOut implements GenerateRandomCheckOutTime {

    Ticket ticket;

    public CheckOut(){
        Random random = new Random();
        try{
            if (GarageController.list.tickets.size() > 0){
                int index = random.nextInt(GarageController.list.tickets.size());
                this.ticket = GarageController.list.tickets.get(index);
                this.ticket.setCheckOutTime(generateCheckOutTime());

                NormalReceipt receipt = new NormalReceipt(this.ticket);
                receipt.printReceipt();


                GarageController.list.tickets.remove(this.ticket);
            }else {
                System.out.println("Perhaps you snuck in, there are no record of vehicles currently parked.");
                System.out.println("Generating lost ticket receipt....");
                new LostTicketReceipt();
            }



        }catch(Exception e){
            System.out.println(e.getMessage());
        }
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


    static long calculateHours(Ticket ticket) {
        long hours = 0;

        hours = Duration.between(ticket.getCheckInTime(), ticket.getCheckOutTime()).toHours();

        return hours;
    }


   static long calculateMinutes(Ticket ticket) {
        long minutes = 0;

        minutes = Duration.between(ticket.getCheckInTime(), ticket.getCheckOutTime()).toMinutes();

        while (minutes > 60) {
            minutes -= 60;
        }
        return minutes;
    }


    public double calculateFees(Ticket ticket) {
        double fee = 0;
        long hours;
        long minutes;

        try {
            hours = calculateHours(ticket);
            minutes = calculateMinutes(ticket);

            hours += minutes > 0 ? 1 : 0;

            if (hours <= 3) {
                fee = 5.00;
            } else if (hours >= 5) {
                fee = 15;
            } else {
                long extraHours = hours - 3;
                fee = (extraHours * 1.00) + 5.00;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

       // GarageData.totalCheckOutFees += fee;

        return fee;
    }

}
