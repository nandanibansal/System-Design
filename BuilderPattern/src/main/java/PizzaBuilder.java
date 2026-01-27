public abstract class PizzaBuilder {

    boolean cheese;
    boolean mushroom;
    boolean basePizza;

    public PizzaBuilder setCheese(){
        this.cheese = true;
        System.out.println("Cheese");
        return this;
    }

    public PizzaBuilder setMushroom(){
        this.mushroom = true;
        System.out.println("Mushroom");
        return this;
    }

    public PizzaBuilder setBasePizza(){
        this.basePizza = true;
        System.out.println("Base Pizza");
        return this;
    }

    public Pizza build(){
        return new Pizza(this);
    }
}
