package entities;

public class Movie {


    private String _title;
    private Price _price;


    public Movie(String title, int arg) {
        _title = title;
        setPriceCode(arg);
    }

    public int getPriceCode() {
        return _price.getPriceCode();
    }

    public void setPriceCode(int arg) {
        switch (arg) {
            case Price.CHILDREN:
                _price = new ChildrensPrice();
                break;
            case Price.REGULAR:
                _price = new RegularPrice();
                break;
            case Price.NEW_RELEASE:
                _price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    public String getTitle() {
        return _title;
    }

    public double getCharge(int daysRented) {
        return _price.getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        return _price.getFrequentRenterPoints(daysRented);
    }
}
