package ParkingApplication.factory;

import ParkingApplication.Ticket;
import ParkingApplication.receipt.Receipt;

public interface ReceiptFactory {
    Receipt make(Ticket ticket);
}
