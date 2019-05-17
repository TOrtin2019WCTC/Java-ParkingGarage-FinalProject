package ParkingApplication;

import java.time.LocalTime;

/**
 * Interface used for generating random check out time
 * @author Tim Ortin
 */
public interface GenerateRandomCheckOutTime {
    LocalTime generateCheckOutTime();
}
