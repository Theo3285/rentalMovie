package rental.movie;

public class Rental {
	private entities.Movie _movie;
	private int _daysRented;

	public Rental(entities.Movie movie, int daysRented) {
		_movie = movie;
		_daysRented = daysRented;
	}

	public entities.Movie getMovie() {
		return _movie;
	}

	public int getDaysRented() {
		return _daysRented;
	}
	
	
}
