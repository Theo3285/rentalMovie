package entities;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;


/**
 * Created by christophe on 28/07/2017.
 */
public class CustomerTestSuite {

    @Test
    public void given_ARegularMovie_When_DaysRentedIs3_Then_AmountOwedIs3Dot5_And_FrequentRenterPointIs1() {
        Customer customer = new Customer("CUST_ONE");
        Movie aMovie = new Movie("MOVIE_ONE", Price.REGULAR);
        Rental aRental = new Rental(aMovie, 3);
        customer.addRental(aRental);

        String result = customer.renderStringStatement();

        System.out.println(result);
        assertThat(result, containsString("Rental Record for CUST_ONE\n" +
                "\tMOVIE_ONE\t3.5\n" +
                "Amount owed is 3.5\n" +
                "You earned 1 frequent renter points"));
    }

    @Test
    public void given_AChildrenMovie_When_DaysRentedIs4_Then_AmountOwedIs3Dot0_And_FrequentRenterPointIs1() {
        Customer customer = new Customer("CUST_TWO");
        Movie aMovie = new Movie("MOVIE_TWO", Price.CHILDREN);
        Rental aRental = new Rental(aMovie, 4);
        customer.addRental(aRental);

        String result = customer.renderStringStatement();

        System.out.println(result);
        assertThat(result, containsString("Rental Record for CUST_TWO\n" +
                "\tMOVIE_TWO\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points"));
    }

    @Test
    public void given_ANewReleaseMovie_When_DaysRentedIs6_Then_AmountOwedIs18Dot0_And_FrequentRenterPointIs2() {
        Customer customer = new Customer("CUST_FOUR");
        Movie aMovie = new Movie("MOVIE_FOUR", Price.NEW_RELEASE);
        Rental aRental = new Rental(aMovie, 6);
        customer.addRental(aRental);

        String result = customer.renderStringStatement();

        System.out.println(result);
        assertThat(result, containsString("Rental Record for CUST_FOUR\n" +
                "\tMOVIE_FOUR\t18.0\n" +
                "Amount owed is 18.0\n" +
                "You earned 2 frequent renter points"));
    }

    @Test
    public void given_ANewReleaseAndAChildrenMovies_When_DaysRentedIs6_Then_AmountOwedIs24Dot0_And_FrequentRenterPointIs3() {
        Customer customer = new Customer("CUST_THREE");
        Movie movie1 = new Movie("MOVIE_THREE", Price.CHILDREN);
        Rental rental1 = new Rental(movie1, 6);
        customer.addRental(rental1);
        Movie movie2 = new Movie("MOVIE_FOUR", Price.NEW_RELEASE);
        Rental rental2 = new Rental(movie2, 6);
        customer.addRental(rental2);
        String result = customer.renderStringStatement();

        System.out.println(result);
        assertThat(result, containsString("Rental Record for CUST_THREE\n" +
                "\tMOVIE_THREE\t6.0\n" +
                "\tMOVIE_FOUR\t18.0\n" +
                "Amount owed is 24.0\n" +
                "You earned 3 frequent renter points"));
    }
}
