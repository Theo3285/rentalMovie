package usecases;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import entities.Customer;
import entities.Movie;
import entities.Price;
import entities.Rental;

/**
 * Created by christophe on 29/07/2017.
 */
public class CalculateRentalTest {


    @Test
    public void totalRenterPointsIsTwo_IfMovieIsNewRelease_And_DaysRentedGreaterThanOne() {
        Customer customer = new Customer("CUST_ONE");
        Movie aMovie = new Movie("MOVIE_ONE", Price.NEW_RELEASE);
        Rental aRental = new Rental(aMovie, 6);
        customer.addRental(aRental);

        int frequentRenterPoints = customer.getTotalFrequentRenterPoints();

        assertEquals(2, frequentRenterPoints);
    }

    @Test
    public void totalRenterPointsIsOne_IfMovieIsNewRelease_And_DaysRentedIsOne() {
        Movie aMovie = new Movie("MOVIE_ONE", Price.NEW_RELEASE);
        Rental aRental = new Rental(aMovie, 1);

        CalculateRental cr = new CalculateRental(aRental);

        int frequentRenterPoints = cr.getTotalFrequentRenterPoints();

        assertEquals(1, frequentRenterPoints);
    }

    @Test
    public void totalChargeIsThreeDotFive_IfMovieIsRegular_And_DaysRentedIsThree() {
        Movie aMovie = new Movie("MOVIE_TWO", Price.REGULAR);
        Rental aRental = new Rental(aMovie, 3);

        CalculateRental cr = new CalculateRental(aRental);

        double totalCharge = cr.getTotalCharge();

        assertEquals(3.5, totalCharge, 0);
    }
}
