package Toppings;

import PizzaClasses.BasePizza;
import PizzaClasses.ToppingDecorator;

public class Mushroom extends ToppingDecorator {

    public Mushroom(BasePizza basePizza){
        super(basePizza);
    }

    @Override
    public String getDescription(){
        return basePizza.getDescription() + " Extra Mushroom";
    }

    @Override
    public double getCost(){
        return basePizza.getCost() + 15;
    }
}
