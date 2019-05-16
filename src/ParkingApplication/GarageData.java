package ParkingApplication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public enum GarageData {
    INSTANCE;

    int totalCheckIns = 0;
    double totalCheckOutFees = 0;
    int totalLostTickets = 0;
    double totalLostTicketFees = 0;
    int totalSpecialEventTickets = 0;
    double totalSpecialEventFees = 0;

    public int getTotalCheckIns() {
        return totalCheckIns;
    }
    public void addTotalCheckIns(){
        totalCheckIns++;
    }

    public double getTotalCheckOutFees() {
        return totalCheckOutFees;
    }
    public void addTotalCheckOutFees(double fee){
        totalCheckOutFees+= fee;
    }

    public int getTotalLostTickets() {
        return totalLostTickets;
    }
    public void addTotalLostTickets(){
        totalLostTickets++;
    }

    public double getTotalLostTicketFees() {
        return totalLostTicketFees;
    }
    public void addTotalLostTicketFees(double fee){
        totalLostTicketFees+= fee;
    }

    public double getTotalFees() {
        return totalCheckOutFees + totalLostTicketFees + totalSpecialEventFees;
    }

    public int getTotalSpecialEventTickets() {
        return totalSpecialEventTickets;
    }
    public void addTotalSpecialEventFees(double fee){
        totalSpecialEventFees += fee;
    }
    public void addTotalSpecialEventTickets(){
        totalSpecialEventTickets++;
    }

    public double getTotalSpecialEventFees() {
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


                }


        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }


    }

    public void generateReport(){

        System.out.println("\n\n\tBest Value Parking Garage");
        System.out.println("\n\t===============================");
        System.out.println("\tActivity to Date\n");
        System.out.println("\t" + CurrencyFormatter.currencyFormatter(totalCheckOutFees) + " was collected from " + totalCheckIns +
                " Check Ins");
        System.out.println("\t" + CurrencyFormatter.currencyFormatter(totalLostTicketFees) + " was collected from " + totalLostTickets +
                " Lost Tickets");
        System.out.println("\t" + CurrencyFormatter.currencyFormatter(totalSpecialEventFees) + " was collected from " + totalSpecialEventTickets
        + " Special Event Tickets\n");
        System.out.println("\t" + CurrencyFormatter.currencyFormatter(getTotalFees()) + " was collected overall");
        System.out.println("\t------------------------------\n\n");

    }




}
