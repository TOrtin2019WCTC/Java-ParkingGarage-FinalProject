package ParkingApplication;

import java.text.NumberFormat;

public interface CurrencyFormatter {

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
