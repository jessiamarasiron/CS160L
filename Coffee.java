import java.util.List;

public interface Coffee {

    //Calculates and returns cost of coffee
    public double getCost();

    //Retrieve list of ingredients for coffee
    public List<String> getIngredients();

    //Prints description of coffee
    public String printCoffee();
}
