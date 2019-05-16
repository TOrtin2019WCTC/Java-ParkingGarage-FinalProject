package ParkingApplication.strategy;

public class LostTicketStrategy extends FeeStrategy {

    private final double FEE = 25.00;

    public LostTicketStrategy(){

    }
    @Override
    public double getFee() {
        return FEE;
    }
}
