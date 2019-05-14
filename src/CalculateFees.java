public abstract class CalculateFees {

   static double calculateFees(Ticket ticket){
       double fee = 0;
       long hours;
       long minutes;

       try {
           hours = CheckOut.calculateHours(ticket);
           minutes = CheckOut.calculateMinutes(ticket);

           hours += minutes > 0 ? 1 : 0;

           if (hours <= PricesAndFees.MINIMUM_HOURS) {
               fee = PricesAndFees.MINIMUM_FEE;
           } else if (hours >= PricesAndFees.MAX_CHARGEABLE_HOURS) {
               fee = PricesAndFees.MAX_FEE;
           } else {
               long extraHours = hours - 3;
               fee = (extraHours * PricesAndFees.CHARGE_PER_ADDITIONAL_HOUR) + PricesAndFees.MINIMUM_FEE;
           }
       } catch (Exception e) {
           e.printStackTrace();
       }

       // GarageData.totalCheckOutFees += fee;

       return fee;
   }


}
