package entities;

/**
 * Created by christophe on 29/07/2017.
 */
public class RegularPrice extends Price {

    @Override
    public int getPriceCode() {
        return REGULAR;
    }

    public double getCharge(int daysRented) {
        double anAmount = 2;
        if (daysRented > 2)
            anAmount += (daysRented - 2) * 1.5;
        return anAmount;
    }
}
