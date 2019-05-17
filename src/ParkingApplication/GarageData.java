package ParkingApplication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Singleton enum stores garage activity to date totals and calculates them.
 * also writes the totals to csv file
 * @author Tim Ortin
 */
public enum GarageData {
    INSTANCE;

    int totalCheckIns = 0;
    double totalCheckOutFees = 0;
    int totalLostTickets = 0;
    double totalLostTicketFees = 0;
    int totalSpecialEventTickets = 0;
    double totalSpecialEventFees = 0;

    /**
     * method returns total number of check ins
     * @return int
     */
    public int getTotalCheckIns() {
        return totalCheckIns;
    }

    /**
     * method increments total number of check ins by 1
     */
    public void addTotalCheckIns(){
        totalCheckIns++;
    }

    /**
     * method returns total check out fees
     * @return double
     */
    public double getTotalCheckOutFees() {
        return totalCheckOutFees;
    }

    /**
     * method adds to total check out fees
     * @param fee double amount to be added
     */
    public void addTotalCheckOutFees(double fee){
        totalCheckOutFees+= fee;
    }

    /**
     * method returns total lost tickets
     * @return int
     */
    public int getTotalLostTickets() {
        return totalLostTickets;
    }

    /**
     * method increments total number of lost tickets by 1
     */
    public void addTotalLostTickets(){
        totalLostTickets++;
    }

    /**
     * method returns the total lost ticket fees
     * @return double
     */

    public double getTotalLostTicketFees() {
        return totalLostTicketFees;
    }

    /**
     * method adds to total lost ticket fees
     * @param fee double amount to be added
     */
    public void addTotalLostTicketFees(double fee){
        totalLostTicketFees+= fee;
    }

    /**
     * returns the total fees
     * @return double
     */
    public double getTotalFees() {
        return totalCheckOutFees + totalLostTicketFees + totalSpecialEventFees;
    }

    /**
     * method returns total number of special event tickets
     * @return int
     */
    public int getTotalSpecialEventTickets() {
        return totalSpecialEventTickets;
    }

    /**
     * method adds to total special event fees
     * @param fee double amount of to be added
     */
    public void addTotalSpecialEventFees(double fee){
        totalSpecialEventFees += fee;
    }

    /**
     * method increments total special event tickets by 1
     */
    public void addTotalSpecialEventTickets(){
        totalSpecialEventTickets++;
    }

    /**
     * method returns total of special event fees
     * @return double
     */
    public double getTotalSpecialEventFees() {
        return totalSpecialEventFees;
    }

    String filePath = null;

    List<Double> garageData = new ArrayList<>();

    /**
     * method sets the location of file to be written
     * @param filePath String name of file
     */
    public void setFilePath(String filePath){
        this.filePath = filePath;
    }

    /**
     * method formats a String to be written to file
     * @return String string of totals to be written to file
     */
    public String fileOutputString() {
        return "TotalCheckOutFees,TotalCheckIns,TotalLostTicketFees,TotalLostTickets,TotalSpecialEventFees,TotalSpecialEvent" +
                "Tickets,TotalFees\n" +
                getTotalCheckOutFees() + "," + getTotalCheckIns() + "," + getTotalLostTicketFees() + "," +
                 getTotalLostTickets() + "," + getTotalSpecialEventFees() + "," + getTotalSpecialEventTickets() + "," +
                getTotalFees();
    }

    /**
     * writes the garage totals to file
     * @param s String lines to write to file
     */
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

    /**
     * method reads garage totals in from file and sets the values of class properties
     */
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

    /**
     * method generates report of activity totals when the garage is closed
     */
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
