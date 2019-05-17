package ParkingApplication;

/**
 * Class is singleton for user interface. handles the two terminal menus
 * @author Tim Ortin
 */
public class UISingleton {

    private String garageName;

    private static UISingleton instance = null;

    /**
     * method privately constructs UISingleton object
     */
    private UISingleton(){
    }

    /**
     * method checks if there is currently an instance of UISingleton
     * if not, method creates new instance
     * @return UISingleton returns thread safe instance of UISingleton object
     */
    public synchronized static UISingleton getInstance() {
        if (instance == null){
            instance = new UISingleton();
        }
        return instance;

    }

    /**
     * method prints menu one to console
     * @param name String name of garage
     */
    public void MenuOne(String name){
        if(name != null){
            this.garageName = name;
        }else{
            this.garageName = "Best Value Parking Garage";
        }

        System.out.println(garageName);
        System.out.println("================");
        System.out.println();
        System.out.println("1. Check in ");
        System.out.println();
        System.out.println("2. Special Event");
        System.out.println();
        System.out.println("3. Close Garage");
        System.out.println("=>_");
    }

    /**
     * method prints menu two to console
     * @param name String name of garage
     */
    public void MenuTwo(String name){

        System.out.println(garageName);
        System.out.println("=================");
        System.out.println();
        System.out.println("1. Check Out ");
        System.out.println();
        System.out.println("2. Lost ParkingApplication.Ticket");
        System.out.println();
        System.out.println("=>_");
    }

}







