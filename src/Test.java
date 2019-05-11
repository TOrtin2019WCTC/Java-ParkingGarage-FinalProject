import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String userInput;

        UISingleton ui = UISingleton.getInstance();
        SingletonParkedCarsList garage = SingletonParkedCarsList.INSTANCE;

        do{
            ui.MenuOne("Tim's Garage");
            userInput = keyboard.nextLine();

            switch(userInput){
                case "1":
                    break;
                case "2":
                    break;
            }

            ui.MenuTwo();
        }while(!userInput.equals("3"));

    }
}
