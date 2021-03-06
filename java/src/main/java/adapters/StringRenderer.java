package adapters;

import entities.Customer;
import entities.Movie;
import entities.Price;
import entities.Rental;
import usecases.RentalCalculator;

/**
 * Created by christophe on 30/07/2017.
 */
public class StringRenderer {

    //private Customer _customer;
    private RentalCalculator _calculateRental;

    public StringRenderer(String aCustomerName, String aMovieTitle, int daysRented) {
         Rental aRental = new Rental
                .RentalBuilder(aMovieTitle, Price.REGULAR)
                .customer(aCustomerName)
                .daysRented(daysRented)
                .build();

        CalculatorFactory factory = new CalculatorFactory(CalculatorFactory.CALCULATE_RENTAL);
        _calculateRental = factory.getInstance();
        _calculateRental.addRental(aRental);
    }

    public String renderStatement() {
        String statement = "Rental Record for " + _calculateRental.getCustomerNames() + "\n";
        statement += _calculateRental.getMovieList();
        statement += "Amount owed is " + String.valueOf(_calculateRental.getTotalCharge()) + "\n"
                + "You earned " + String.valueOf(_calculateRental.getTotalFrequentRenterPoints())
                + " frequent renter points";

        return statement;
    }
}
