package usecases;

import entities.Rental;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by christophe on 30/07/2017.
 */
public class CalculateRental implements RentalCalculator {

    private Vector _rentals = new Vector();

    public CalculateRental(Rental arg) {
        addRental(arg);
    }

    public CalculateRental() {
    }


    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public double getTotalCharge() {
        double totalAmount = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental aRental = (Rental) rentals.nextElement();
            totalAmount += aRental.getCharge();
        }
        return totalAmount;
    }

    public int getTotalFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental aRental = (Rental) rentals.nextElement();
            frequentRenterPoints += aRental.getFrequentRenterPoints();
        }
        return frequentRenterPoints;
    }

    public String getMovieList() {
        Enumeration rentals = _rentals.elements();
        String statement = "";

        while (rentals.hasMoreElements()) {
            Rental aRental = (Rental) rentals.nextElement();
            statement += aRental.toString();
        }
        return statement;
    }
}
