package ParkingApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton enum containing a list of vehicles in garage, with add and remove functionality
 * @author Tim Ortin
 */
public enum SingletonParkedCarsList {
    INSTANCE;

    private List<Ticket> tickets = new ArrayList();

    /**
     * method adds a ticket object to the list of vehicles in garage
     * @param ticket Ticket Object
     */
    public void addCar(Ticket ticket){
        tickets.add(ticket);
    }

    /**
     * method removes a ticket object from the list of vehicles in garage
     * @param ticket Ticket object
     */
    public void removeCar(Ticket ticket){
        tickets.remove(ticket);
    }

    /**
     * method returns the current size of array list
     * @return int returns sie of array list
     */
    public int numCars(){
        return tickets.size();
    }

    /**
     * method gets specific Ticket object from the array list
     * @param index int index of ticket to be removed
     * @return Ticket object to be removed from list
     */
    public Ticket getTicket(int index){
        return tickets.get(index);
    }
}
