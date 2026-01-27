//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        Director director = new Director(pizzaBuilder);
        PizzaBuilder pizzaBuilder = new VegPizza();
        Pizza pizza = pizzaBuilder.setBasePizza().build();
        System.out.println(pizza.toString());
        pizza = pizzaBuilder.setBasePizza().setMushroom().build();
        System.out.println(pizza.toString());
    }
}