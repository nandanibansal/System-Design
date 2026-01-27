package Toppings;

import PizzaClasses.BasePizza;
import PizzaClasses.ToppingDecorator;

public class Cheese extends ToppingDecorator {

    public Cheese(BasePizza basePizza){
        super(basePizza);
    }

    @Override
    public String getDescription(){
        return basePizza.getDescription() + " Extra Cheese";
    }

    @Override
    public double getCost(){
        return basePizza.getCost() + 10;
    }
}
