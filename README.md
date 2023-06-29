# CS160L
Java Coffee Co. ORDERING SYSTEM

This is a Coffee Ordering System designed for Java Coffee Co. 

UTILIZATION OF THE SYSTEM:
The Main Class prints out the main menu from which users have 6 options and 1 exit button:
1 - New Order,
2 - Reload Inventory,
3 - Update Inventory,
4 - Update Order Log,
5 - View Statistics,
6 - About MyBeanRewards,
7 - Exit

In "New Order", users are prompted to enter a loyalty number for MyBeanRewards, the loyalty program for Java Coffee Co. This is optional;
users can then create custom cofffee orders using various add-ons such flavors, milk, toppings, and sugar. When the user is done, an order
prints out and includes the total cost of their order with a description of every customization, and if inputted, the loyalty points earned.

In "Reload Inventory", a list of current ingredients in stock is printed.

In "Update Inventory", a user can input the name of an ingredient to add to the inventory stock.

In 'Update Order Log", this updates the order log of all previous orders while the system is running.

In "View Statistics", users can view the total costs of all previous orders and the average costs of all previous orders while the system is running.

In "About MyBeanRewards", users can view inofrmation about the loyalty program.


DESCRIPTION OF EACH FILE:

BlackCoffee.java: This class represents a basic black coffee object. It implements the Coffee interface and provides methods for the getCost(), getIngredients(), and printCoffee().  It returns the cost, ingredients, and a string representation of a black coffee.


Coffee.java: This interface defines the methods of the coffee object; getCost(), getIngredients(), and printCoffee(). Any class that implements this interface needs to reference these methods.

CoffeeDecorator.java: This is the base class for all the coffee decorators. It implements the Coffee interface and structures coffee decorators to call the decorated coffee object.

CoffeeOrder.java: This class represents an order. It has a list of base Coffees, methods to get an order date, a member ID and to calculate the total cost and loyalty points. It also provides methods to add coffee, get the list of coffees, and print the order details.

Espresso.java: This class represents an espresso coffee object. It implements the Coffee interface and provides methods for the getCost(), getIngredients(), and printCoffee() methods. It returns the cost, ingredients, and a string representation of an espresso coffee.

Inventory.txt: This is a text document of the default inventory for the system.

Main.java: This is the main class that serves as the starting point for the Java Coffee Co. ordering system. It allows users to interact with the system, place orders, manage inventory, view statistics, and more. 

Statistics.java: This class calculates statistics for a list of coffee orders. The getTotal() method calculates the total cost of all coffee orders by adding up their individual costs, then returning it. The getAvgCost()method calculates the average cost of the coffee orders, then returns it.

WithFlavor.java: This class is a decorator class that extends the CoffeeDecorator class and adds flavor to a base coffee. Syrup represents the available flavor options, then uses the getCost(), getIngredients(), and printCoffee() methods to add the extra costs to the coffee and a description to include with the final printout of the order.

WithHotWater.java: This class is a decorator class that extends the CoffeeDecorator class and adds hot water to a base coffee. It then uses the getCost(), getIngredients(), and printCoffee() methods to add hot water to the coffee and a description to include with the final printout of the order.

WithMilk.java: This class is a decorator class that extends the CoffeeDecorator class and adds milk to a base coffee. Milk represents the available cream options, then uses the getCost(), getIngredients(), and printCoffee() methods to add the extra costs to the coffee and a description to include with the final printout of the order.

WithSugar.java: This class is a decorator class that extends the CoffeeDecorator class and adds flavor to a base coffee. Sugar represents the available sweetener options, then uses the getCost(), getIngredients(), and printCoffee() methods to add the extra costs to the coffee and a description to include with the final printout of the order.

WithWhippedCream.java: This class is a decorator class that extends the CoffeeDecorator class and adds whipped cream and other toppings to a base coffee. WhipCream represents the available topping options, then uses the getCost(), getIngredients(), and printCoffee() methods to add the extra costs to the coffee and a description to include with the final printout of the order.
