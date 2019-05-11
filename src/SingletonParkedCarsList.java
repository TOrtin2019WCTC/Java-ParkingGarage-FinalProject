

import java.util.ArrayList;
import java.util.List;

public enum SingletonParkedCarsList {
    INSTANCE;

    List<Ticket> tickets = new ArrayList();


    public void addCar(Ticket ticket){
        tickets.add(ticket);
    }

    public void removeCar(Ticket ticket){
        tickets.remove(ticket);
    }
}
