
public class GarageController {

    static String garageName;
    static SingletonParkedCarsList list  = SingletonParkedCarsList.INSTANCE;
    static GarageData garageData = GarageData.INSTANCE;

    public static void main(String[] args) {

        UISingleton ui = UISingleton.getInstance();
        InputReader reader = new KeyboardInput();

        System.out.println("Enter garage name:");
        garageName = reader.readUserInput();
        String userChoice;


        //new CheckIn();
        new CheckOut();


//        do {
//        System.out.println("1. Check In Menu");
//        System.out.println("2. Check Out Menu");
//        System.out.println("3. Exit");
//
//        userChoice = reader.readUserInput();
//
//        if (userChoice.equals("1") || userChoice.equals("2")){
//
//        }
//            switch(userChoice){
//                case "1":
//                    ui.MenuOne(garageName);
//                    userChoice = reader.readUserInput();
//
//                    switch(userChoice){
//                        case "1":
//                            new CheckIn();
//                            break;
//                        case "2":
//                            System.out.println("Shit");
//                            break;
//                        default:
//                            break;
//                    }
//            }
//
//        }while (!userChoice.equals("3"));
//
//        switch(userChoice){
//            case "1":
//
//        }





    }
}
