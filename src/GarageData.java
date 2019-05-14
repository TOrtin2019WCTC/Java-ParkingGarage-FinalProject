import java.util.ArrayList;
import java.util.List;

public enum GarageData {
    INSTANCE;

    static int totalCheckIns = 0;
    static double totalCheckOutFees = 0;
    static int totalLostTickets = 0;
    static double totalLostTicketFees = 0;
    static double totalFees = 0;
    static int totalSpecialEventTickets = 0;
    static double totalSpecialEventFees = 0;

    List<Double> garageData = new ArrayList<>();


}
