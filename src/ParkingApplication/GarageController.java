package ParkingApplication;


import ParkingApplication.strategy.MinMaxTicketStrategy;
import ParkingApplication.strategy.SpecialEventStrategy;

public class GarageController {

    public static String garageName;
    static SingletonParkedCarsList list  = SingletonParkedCarsList.INSTANCE;
    public static GarageData garageData = GarageData.INSTANCE;

    public static void main(String[] args) {

        UISingleton ui = UISingleton.getInstance();
        InputReader reader = new KeyboardInput();
        System.out.println("Enter garage name:");
        garageName = reader.readUserInput();
        garageData.setFilePath("Best-Value-Parking-Garage-Data.txt");
        garageData.readDataFromFile();
        String userChoice;


        mainloop : do {
            System.out.println("1. Check In Menu");
            System.out.println("2. Check Out Menu");
            System.out.println(" quit to  Exit");

            userChoice = reader.readUserInput().toLowerCase();

            if (userChoice.equals("1") || userChoice.equals("2")) {

                CheckOut checkOut = new CheckOut();

                if (userChoice.equals("1")) {

                    ui.MenuOne(garageName);
                    userChoice = reader.readUserInput();
                    switch (userChoice) {
                        case "1":
                            new CheckIn(new MinMaxTicketStrategy());
                            break;
                        case "2":
                            new CheckIn(new SpecialEventStrategy());
                            break;
                        case "3":
                            break mainloop;
                        default:
                            break;
                    }
                } else if(userChoice.equals("2")){

                        ui.MenuTwo(garageName);
                        userChoice = reader.readUserInput();
                        switch (userChoice) {
                            case "1":
                                checkOut.checkOut();
                                break;
                            case "2":
                                checkOut.lostTicket();
                                break;
                        }
                }


            }
        } while (!userChoice.equals("quit")) ;



            garageData.generateReport();
            garageData.writeDataToFile(garageData.fileOutputString());
            System.out.println("Garage Closed");


        }

    }

