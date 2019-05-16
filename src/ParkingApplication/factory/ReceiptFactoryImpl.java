package ParkingApplication.factory;

import ParkingApplication.Ticket;
import ParkingApplication.receipt.LostTicketReceipt;
import ParkingApplication.receipt.NormalReceipt;
import ParkingApplication.receipt.Receipt;
import ParkingApplication.receipt.SpecialEventReceipt;
import ParkingApplication.strategy.LostTicketStrategy;
import ParkingApplication.strategy.MinMaxTicketStrategy;
import ParkingApplication.strategy.SpecialEventStrategy;

public class ReceiptFactoryImpl implements ReceiptFactory {


    @Override
    public Receipt make(Ticket ticket) {

        if(ticket == null){
            return new LostTicketReceipt(ticket);
        }else if(ticket.getFeeStrategy() instanceof LostTicketStrategy){
            return new LostTicketReceipt(ticket);
        }else if(ticket.getFeeStrategy() instanceof SpecialEventStrategy){
            return new SpecialEventReceipt(ticket);
        }else if(ticket.getFeeStrategy() instanceof MinMaxTicketStrategy){
            return new NormalReceipt(ticket);
        }

        return null;
    }
}
