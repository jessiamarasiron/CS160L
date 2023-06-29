/**
 *  Java Coffee Co. ORDERING SYSTEM
 *  CS160-1001
 *  06/28/2023
 * @author Jessicaamara Siron
 */

import java.util.List;

    /**
     * The WithHotWater class represents a flavor decorator.
     * It extends the CoffeeDecorator class.
     */
public class WithHotWater extends CoffeeDecorator {

        /**
         * Constructs a new WithHotWater object with specified coffee and hot water
         *
         * @param coffee The base coffee to add hot water to.
         *
         */
    public WithHotWater(Coffee coffee) {
        super(coffee);
    }

        /**
         * Calculates cost of coffee with added hot water.
         *
         * @return cost of the coffee with added hot water. No extra cost.
         */
    @Override
    public double getCost() {
        return super.getCost() + 0.00;
    }

        /**
         * Gets ingredients of coffee with added hot water.
         *
         * @return list of ingredients of coffee with added hot water.
         */
    @Override
    public List<String> getIngredients() {
        List<String> getingredients = super.getIngredients();
        getingredients.add("Hot Water");
        return getingredients;
    }

    /**
     * Prints a string representation of coffee with added hot water.
     *
     * @return string representation of coffee with added hot water.
     */
    @Override
    public String printCoffee() {
        return super.printCoffee() + " with hot water";
    }
}
