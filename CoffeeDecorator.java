import java.util.List;
public abstract class CoffeeDecorator implements Coffee {
    private Coffee coffee;

    //initializes decorated coffee object
    public CoffeeDecorator(Coffee c) {
        coffee = c;

    }

    //implements from Coffee interface, calls to decorated coffee object
    public double getCost() {
        return coffee.getCost();
    }

    //implements from Coffee interface, calls to decorated coffee object
    public List<String> getIngredients() {
        return coffee.getIngredients();
    }


    //implements from Coffee interface, calls to decorated coffee object
    public String printCoffee() {
        return coffee.printCoffee();
    }
}
