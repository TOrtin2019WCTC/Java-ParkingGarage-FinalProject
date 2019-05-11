import java.util.Scanner;

public class KeyboardInput extends InputReader {

    private Scanner keyboard;

    public KeyboardInput(){
        keyboard = new Scanner(System.in);
    };


    @Override
   public String readUserInput() {
        return keyboard.nextLine();

    }

}
