package ParkingApplication.strategy;

import ParkingApplication.strategy.FeeStrategy;

/**
 * Class is subclass of FeeStrategy superclass
 * @author Tim Ortin
 */

public class SpecialEventStrategy extends FeeStrategy {

    private final double FEE = 20.00;

    /**
     * Method creates instance of SpecialEventStrategy
     */
    public SpecialEventStrategy(){

    }

    /**
     * Method gets the fee of this class
     * @return double fee
     */
    @Override
    public double getFee() {
        return FEE;
    }
}
