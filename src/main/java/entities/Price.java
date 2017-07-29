package entities;

/**
 * Created by christophe on 29/07/2017.
 */
public abstract class Price {

    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;


    public int getFrequentRenterPoints(int daysRented) {
        // add bonus for a two day new release rental
        if ((getPriceCode() == NEW_RELEASE)
                && daysRented > 1)
            return 2;
        else
            return 1;
    }

    public abstract int getPriceCode();

    public abstract double getCharge(int daysRented) ;

}
