package BasePizzasa;

import PizzaClasses.BasePizza;

public class PlainPizza implements BasePizza {
    @Override
    public String getDescription() {
        return "Plain Pizza";
    }

    @Override
    public double getCost() {
        return 5.99;
    }
}
