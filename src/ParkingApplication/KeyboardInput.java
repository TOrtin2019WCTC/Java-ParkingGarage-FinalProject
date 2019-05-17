package ParkingApplication;

import java.util.Scanner;

/**
 * Class is subclass of InputReader superclass and handles user input from keyboard
 * @author Tim Ortin
 */
public class KeyboardInput extends InputReader {

    private Scanner keyboard;

    /**
     * Method creates instance of KeyboardInput and initializes the Scanner Object
     */
    public KeyboardInput(){
        keyboard = new Scanner(System.in);
    };

    /**
     * Method returns the String from input entered on keyboard
     * @return String returns String of user input
     */
    @Override
   public String readUserInput() {
        return keyboard.nextLine();

    }

}
