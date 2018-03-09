package entities;

/**
 * Created by christophe on 29/07/2017.
 */
public class NewReleasePrice extends Price {
    @Override
    public int getPriceCode() {
        return NEW_RELEASE;
    }

    public double getCharge(int daysRented) {
        return daysRented * 3;
    }
}
