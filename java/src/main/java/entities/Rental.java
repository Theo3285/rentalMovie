package entities;

import entities.Movie;

public class Rental {
    private Customer _customer;
    private Movie _movie;
    private int _daysRented;

    public Rental (RentalBuilder builder) {
        this._customer = builder.customer;
        this._movie = builder.movie;
        this._daysRented = builder.daysRented;
    }

    public Customer getCustomer() {
        return _customer;
    }

    public String getName() { return _customer.getName(); }

    public Movie getMovie() {
        return _movie;
    }

    public String getTitle() { return _movie.getTitle(); }

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

    public static class RentalBuilder {
        private Customer customer;
        private static Movie movie;
        private int daysRented;

        public RentalBuilder(String aTitle, int priceCode) {
            this.movie = new Movie(aTitle, priceCode);
        }
        public RentalBuilder customer (String aCustomer) {
            this.customer = new Customer(aCustomer);
            return this;
        }
        public RentalBuilder daysRented(int someDays) {
            this.daysRented = someDays;
            return this;
        }

        public Rental build() {
            return new Rental(this);
        }
    }
}
