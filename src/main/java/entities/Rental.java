package entities;

import entities.Movie;

public class Rental {
    private Movie _movie;
    private int _daysRented;

    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public double getCharge() {
        return _movie.getCharge(getDaysRented());
    }

    public int getFrequentRenterPoints() {
        return _movie.getFrequentRenterPoints(getDaysRented());
    }

    public String toString() {
        // show figures for this rental
        return "\t" + getMovie().getTitle() + "\t"
                + String.valueOf(getCharge()) + "\n";
    }
}
