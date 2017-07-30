package usecases;

import entities.Customer;
import entities.Rental;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by christophe on 30/07/2017.
 */
public class CalculateRental {

    private Vector _rentals = new Vector();

    public CalculateRental(Rental arg) {
        addRental(arg);
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
}
