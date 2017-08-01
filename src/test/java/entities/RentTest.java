package entities;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by christophe on 01/08/2017.
 */
public class RentTest {
    @Test
    public void shouldBuildANewRental() {
        Rental rental = new Rental
                .RentalBuilder("Movie1", Price.CHILDREN)
                .customer("Cust1")
                .daysRented(1)
                .build();

        assertEquals("Cust1", rental.getName());
        assertEquals("Movie1", rental.getTitle());
        assertEquals(1, rental.getDaysRented());
        assertEquals(1.5, rental.getCharge(), 0);
        assertEquals(1, rental.getFrequentRenterPoints());
    }
}
