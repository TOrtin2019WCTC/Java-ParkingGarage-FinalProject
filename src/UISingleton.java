public class UISingleton {

    private String garageName;

    private static UISingleton instance = null;

    private UISingleton(){
    }

    public synchronized static UISingleton getInstance() {
        if (instance == null){
            instance = new UISingleton();
        }
        return instance;

    }

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

    public void MenuTwo(String name){

        System.out.println(garageName);
        System.out.println("=================");
        System.out.println();
        System.out.println("1. Check Out ");
        System.out.println();
        System.out.println("2. Lost Ticket");
        System.out.println();
        System.out.println("=>_");
    }

}







