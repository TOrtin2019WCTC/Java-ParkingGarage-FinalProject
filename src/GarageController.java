
public class GarageController {

    static String garageName;
    static SingletonParkedCarsList list  = SingletonParkedCarsList.INSTANCE;
    static GarageData garageData = GarageData.INSTANCE;

    public static void main(String[] args) {

        UISingleton ui = UISingleton.getInstance();
        InputReader reader = new KeyboardInput();
        System.out.println("Enter garage name:");
        garageName = reader.readUserInput();
        garageData.setFilePath("Best-Value-Parking-Garage-Data.txt");
        //garageData.setFilePath(garageName.replace(" ", "-") + "-Data.txt");
        garageData.readDataFromFile();
        String userChoice;


//        new CheckIn();
//        new CheckOut();
        ui.MenuOne(garageName);
        userChoice = reader.readUserInput();
        switch(userChoice){
            case "1":
                new CheckIn(new MinMaxTicketStrategy());
                break;
            case "2":
                new CheckIn(new SpecialEventStrategy());
                break;
            default:
                break;
        }


        do {
        System.out.println("1. Check In Menu");
        System.out.println("2. Check Out Menu");
        System.out.println("3. Exit");

        userChoice = reader.readUserInput();

        if (userChoice.equals("1") || userChoice.equals("2")){

        }
            switch(userChoice){
                case "1":
                    ui.MenuOne(garageName);
                    userChoice = reader.readUserInput();
                    switch(userChoice){
                        case "1":
                            new CheckIn(new MinMaxTicketStrategy());
                            break;
                        case "2":
                            new CheckIn(new SpecialEventStrategy());
                            break;
                        default:
                            break;
                    }

                case "2":
                    ui.MenuTwo(garageName);
                    userChoice = reader.readUserInput();
                    switch(userChoice){
                        case "1":
                            new CheckOut();
                            break;
                        case "2":
                            new LostTicketReceipt().printReceipt();

                            break;
                    }
            }

        }while (!userChoice.equals("3"));
//
//        switch(userChoice){
//            case "1":
//
//        }

        garageData.totalFees = garageData.totalCheckOutFees + garageData.totalLostTicketFees + garageData.totalSpecialEventFees;
        garageData.generateReport();
        garageData.writeDataToFile(garageData.fileOutputString());

        System.out.println("Garage Closed");



    }
}
