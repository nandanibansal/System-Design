package Toppings;

import PizzaClasses.BasePizza;
import PizzaClasses.ToppingDecorator;

public class Veggies extends ToppingDecorator {
    public Veggies(BasePizza basePizza){
        super(basePizza);
    }

    @Override
    public String getDescription(){
        return basePizza.getDescription() + " Veggies";
    }

    @Override
    public double getCost(){
        return basePizza.getCost() + 5;
    }
}
