package ParkingApplication.strategy;

/**
 * class is subclass of FeeStrategy superclass
 */
public class LostTicketStrategy extends FeeStrategy {

    private final double FEE = 25.00;

    /**
     * Method creates instance of LostTicketStrategy
     */
    public LostTicketStrategy(){

    }

    /**
     * method gets fee
     * @return double this returns fee for LostTicketStrategy
     */
    @Override
    public double getFee() {
        return FEE;
    }
}
