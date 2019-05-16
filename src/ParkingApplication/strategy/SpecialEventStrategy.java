package ParkingApplication.strategy;

import ParkingApplication.strategy.FeeStrategy;

public class SpecialEventStrategy extends FeeStrategy {

    private final double FEE = 20.00;

    public SpecialEventStrategy(){

    }


    @Override
    public double getFee() {
        return FEE;
    }
}
