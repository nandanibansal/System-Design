package PizzaClasses;

public abstract class ToppingDecorator implements BasePizza {
    public BasePizza basePizza;

    public ToppingDecorator(BasePizza basePizza) {
        this.basePizza = basePizza;
    }
}
