import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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

    public static int getTotalCheckIns() {
        return totalCheckIns;
    }

    public static double getTotalCheckOutFees() {
        return totalCheckOutFees;
    }

    public static int getTotalLostTickets() {
        return totalLostTickets;
    }

    public static double getTotalLostTicketFees() {
        return totalLostTicketFees;
    }

    public static double getTotalFees() {
        return totalFees;
    }

    public static int getTotalSpecialEventTickets() {
        return totalSpecialEventTickets;
    }

    public static double getTotalSpecialEventFees() {
        return totalSpecialEventFees;
    }

    String filePath = null;

    List<Double> garageData = new ArrayList<>();


    public void setFilePath(String filePath){
        this.filePath = filePath;
    }

    public String fileOutputString() {
        return "TotalCheckOutFees,TotalCheckIns,TotalLostTicketFees,TotalLostTickets,TotalSpecialEventFees,TotalSpecialEvent" +
                "Tickets,TotalFees\n" +
                getTotalCheckOutFees() + "," + getTotalCheckIns() + "," + getTotalLostTicketFees() + "," +
                 getTotalLostTickets() + "," + getTotalSpecialEventFees() + "," + getTotalSpecialEventTickets() + "," +
                getTotalFees();
    }

    public void writeDataToFile(String s) {
        BufferedWriter writer;

        try {

            writer = new BufferedWriter(new FileWriter(this.filePath));
            writer.write(s);
            writer.close();


        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }

    }

    public void readDataFromFile() {

        String path = filePath;
        String line;


        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(path));
            reader.readLine();

                while ((line = reader.readLine()) != null) {
                    String[] tempList = line.split(",");
                    totalCheckOutFees = Double.parseDouble(tempList[0]);
                    totalCheckIns = Integer.parseInt(tempList[1]);
                    totalLostTicketFees = Double.parseDouble(tempList[2]);
                    totalLostTickets = Integer.parseInt(tempList[3]);
                    totalSpecialEventFees = Double.parseDouble(tempList[4]);
                    totalSpecialEventTickets = Integer.parseInt(tempList[5]);
                    totalFees = Double.parseDouble(tempList[6]);

                }


        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }


    }

    public void generateReport(){
        GarageData.totalFees = totalCheckOutFees + totalLostTicketFees + totalSpecialEventFees;

        System.out.println("\n\n\tBest Value Parking Garage");
        System.out.println("\n\t===============================");
        System.out.println("\tActivity to Date\n");
        System.out.println("\t" + CurrencyFormatter.currencyFormatter(GarageData.totalCheckOutFees) + " was collected from " + GarageData.totalCheckIns +
                " Check Ins");
        System.out.println("\t" + CurrencyFormatter.currencyFormatter(GarageData.totalLostTicketFees) + " was collected from " + GarageData.totalLostTickets +
                " Lost Tickets");
        System.out.println("\t" + CurrencyFormatter.currencyFormatter(GarageData.totalSpecialEventFees) + " was collected from " + GarageData.totalSpecialEventTickets
        + " Special Event Tickets\n");
        System.out.println("\t" + CurrencyFormatter.currencyFormatter(GarageData.totalFees) + " was collected overall");
        System.out.println("\t------------------------------\n\n");

    }




}
