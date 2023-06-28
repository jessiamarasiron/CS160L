import java.util.List;
public class WithHotWater extends CoffeeDecorator {
    public WithHotWater(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.00;
    }

    @Override
    public List<String> getIngredients() {
        List<String> getingredients = super.getIngredients();
        getingredients.add("Hot Water");
        return getingredients;

    }

    @Override
    public String printCoffee() {
        return super.printCoffee() + " with hot water";
    }
}
