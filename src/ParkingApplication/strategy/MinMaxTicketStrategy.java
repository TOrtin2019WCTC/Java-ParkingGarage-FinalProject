package ParkingApplication.strategy;

/**
 * class is subclass of FeeStrategy superclass
 * @author Tim Ortin
 */
public class MinMaxTicketStrategy extends FeeStrategy {

    /**
     * Method creates instance of MinMaxTicketStrategy
     */
    public MinMaxTicketStrategy(){

    }

    /**
     * Method gets fee for class
     * @return double fee
     */
    @Override
   public double getFee() {
        return 0;
    }
}
