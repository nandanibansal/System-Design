package BasePizzasa;

import PizzaClasses.BasePizza;

public class VeggieDelight implements BasePizza {
    @Override
    public String getDescription() {
        return "Veggie Delight Pizza";
    }

    @Override
    public double getCost() {
        return 9.99;
    }
}
