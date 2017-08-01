package adapters;

import entities.Movie;
import entities.Price;
import entities.Rental;
import usecases.RentalCalculator;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

/**
 * Created by christophe on 29/07/2017.
 */
public class StringRendererTest {

    @Test
    public void given_ARegularMovie_When_DaysRentedIs3_Then_AmountOwedIs3Dot5_And_FrequentRenterPointIs1() {

        StringRenderer sr = new StringRenderer("CUST_ONE", "MOVIE_ONE", 3);

        String result = sr.renderStatement();

        System.out.println(result);

        assertThat(result, containsString("Rental Record for CUST_ONE\n" +
                "\tMOVIE_ONE\t3.5\n" +
                "Amount owed is 3.5\n" +
                "You earned 1 frequent renter points"));
    }

    @Test
    public void shouldReturnAListOfMoviesWithIndividualChargesAsString(){
        Rental rental1 = new Rental
                .RentalBuilder("MOVIE_THREE", Price.CHILDREN)
                .customer("Cust1")
                .daysRented(6)
                .build();

        Rental rental2 = new Rental
                .RentalBuilder("MOVIE_FOUR", Price.NEW_RELEASE)
                .customer("Cust1")
                .daysRented(6)
                .build();

        CalculatorFactory factory = new CalculatorFactory(CalculatorFactory.CALCULATE_RENTAL);
        RentalCalculator cr = factory.getInstance();

        cr.addRental(rental1);
        cr.addRental(rental2);

        String result = cr.getMovieList();

        System.out.println(result);
        assertThat(result, containsString("\tMOVIE_THREE\t6.0\n" +
                "\tMOVIE_FOUR\t18.0"));
    }
}
