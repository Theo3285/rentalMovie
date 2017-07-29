package entities;

/**
 * Created by christophe on 29/07/2017.
 */
public class ChildrensPrice extends Price {

    @Override
    public int getPriceCode() {
        return CHILDREN;
    }

    public double getCharge(int daysRented) {
        double anAmount = 1.5;
        if (daysRented > 3)
            anAmount += (daysRented - 3) * 1.5;
        return anAmount;
    }
}
