package adapters;

import entities.Rental;

/**
 * Created by christophe on 30/07/2017.
 */
public interface RentalCalculator {

    void addRental(Rental arg);

    double getTotalCharge();

    int getTotalFrequentRenterPoints();

    String getMovieList();
}
