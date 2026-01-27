package BasePizzasa;

import PizzaClasses.BasePizza;

public class Margerita implements BasePizza {

    @Override
    public String getDescription() {
        return "Margerita Pizza";
    }

    @Override
    public double getCost() {
        return 8.99; // Example cost for a Margerita pizza
    }
}
