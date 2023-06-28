import java.util.*;

public class Statistics {
    private List<CoffeeOrder> orders;

    public Statistics(List<CoffeeOrder> orders) {this.orders = orders;}

    public double getTotal() {
        double total = 0;
        for (CoffeeOrder order : orders) {
            total += order.getTotal();
        }
        return total;
    }

    public double getAvgCost() {
        if (orders.isEmpty()) {
            return 0;
        }
        double totalCost = getTotal();
        return totalCost / orders.size();
    }
}


