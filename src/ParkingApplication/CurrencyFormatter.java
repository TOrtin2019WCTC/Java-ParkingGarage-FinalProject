package ParkingApplication;

import java.text.NumberFormat;

/**
 * Interface holds method to format a string to currency format\
 * @author Tim Ortin
 */
public interface CurrencyFormatter {
    /**
     * Method attempts to convert the object passed in to currency format
     * @param o Object any type of object
     * @return String returns a String formatted to currency format
     * @throws throws illegalArgumentException
     */
    static String currencyFormatter(Object o){
        String currencyFormatted = null;

        if (o != null) {
            NumberFormat numberFormatter = NumberFormat.getCurrencyInstance();
            currencyFormatted = numberFormatter.format(o);
        } else {
            throw new IllegalArgumentException();
        }


        return currencyFormatted;
    };
}
