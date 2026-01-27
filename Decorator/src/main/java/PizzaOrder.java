import BasePizzasa.PlainPizza;
import PizzaClasses.BasePizza;
import Toppings.Cheese;
import Toppings.Mushroom;

public class PizzaOrder {
    public static void main(String[] args) {
        BasePizza plainPizza = new PlainPizza();
        System.out.println(plainPizza.getCost() + " " + plainPizza.getDescription());

        BasePizza extraCheese = new Cheese(plainPizza);
        System.out.println(extraCheese.getCost() + " " + extraCheese.getDescription());

        BasePizza extraMushroom = new Mushroom(extraCheese);
        System.out.println(extraMushroom.getCost() + " " + extraMushroom.getDescription());
    }
}