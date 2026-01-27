public class Pizza {

    boolean cheese;
    boolean mushroom;
    boolean basePizza;

    public Pizza(PizzaBuilder pizzaBuilder){
        this.cheese = pizzaBuilder.cheese;
        this.mushroom = pizzaBuilder.mushroom;
        this.basePizza = pizzaBuilder.basePizza;
    }

    public String toString(){
        return "It has cheese? "+ this.cheese + " mushroom? " + this.mushroom + " base pizza? " + this.basePizza;
    }
}
