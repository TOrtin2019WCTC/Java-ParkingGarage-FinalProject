package ParkingApplication;

import java.time.LocalTime;

/**
 * Interface for generating a random check in time
 * @author Tim Ortin
 */
public interface GenerateRandomCheckInTime {
    LocalTime generateCheckInTime();
}
