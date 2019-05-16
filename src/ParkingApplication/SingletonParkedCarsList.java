package ParkingApplication;

import java.util.ArrayList;
import java.util.List;

public enum SingletonParkedCarsList {
    INSTANCE;

    private List<Ticket> tickets = new ArrayList();


    public void addCar(Ticket ticket){
        tickets.add(ticket);
    }

    public void removeCar(Ticket ticket){
        tickets.remove(ticket);
    }

    public int numCars(){
        return tickets.size();
    }

    public Ticket getTicket(int index){
        return tickets.get(index);
    }
}
