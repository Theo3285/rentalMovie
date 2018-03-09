package adapters;

import usecases.CalculateRental;
import usecases.RentalCalculator;

/**
 * Created by christophe on 31/07/2017.
 */
public class CalculatorFactory {
    public static final int CALCULATE_RENTAL = 0;

    private RentalCalculator instance;


    public CalculatorFactory(int instance) {
        if (instance == CALCULATE_RENTAL){
            this.instance = new CalculateRental();
        }
    }

    public RentalCalculator getInstance(){
        return this.instance;
    }
}
