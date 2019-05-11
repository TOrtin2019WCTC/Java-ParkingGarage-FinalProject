import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class GarageController {
    public static void main(String[] args) {

        UISingleton ui = UISingleton.getInstance();
        InputReader reader = new KeyboardInput();
        SingletonParkedCarsList list = SingletonParkedCarsList.INSTANCE;
        System.out.println("Enter garage name:");
        String garageName = reader.readUserInput();
        String userChoice;
        do{
            ui.MenuOne(garageName);
            userChoice = reader.readUserInput();

            switch(userChoice){
                case "1":
                    new CheckIn();
                    break;
                case "2":
                    System.out.println("Shit");
                    break;
                default:
                    break;
            }
        }while(!userChoice.equals("3"));

        for (Ticket ticket : list.tickets){
            System.out.println(ticket.getVehicleID());
            System.out.println(ticket.getCheckInTime());
            System.out.println();
        }

//
//        if(){
//            ui.MenuTwo();
//            switch(reader.readUserInput()){
//                case "1":
//                    System.out.println("Alright then");
//                    break;
//                default:
//                    break;
//            }
//        }


    }
}
