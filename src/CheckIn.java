import java.time.LocalTime;
import java.util.Random;

public class CheckIn implements GenerateRandomCheckInTime {

    static SingletonParkedCarsList garageList;

    public CheckIn(){
        garageList = SingletonParkedCarsList.INSTANCE;
        garageList.addCar(new Ticket(generateCheckInTime()));

    }
    @Override
    public LocalTime generateCheckInTime() {
        Random random = new Random();
        int hours = 0;
        int minutes = 0;
        hours = random.nextInt(11 + 1 - 7) + 7;

        minutes = random.nextInt(59) + 1;
        LocalTime newCheckInTime = LocalTime.of(hours, minutes);
        return newCheckInTime;
    }
}
