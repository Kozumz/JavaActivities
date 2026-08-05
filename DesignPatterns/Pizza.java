package DesignPatterns;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    String size;
    List<String> toppings = new ArrayList<>();

    public String toString(){
        return "Pizza{size='" + size + "', toopings=" + toppings + "}";
    }

    public static void main(String[] args) {
        Pizza pizza = new PizzaBuilder()
                .withSize("Grande")
                .addTopping("Peperoni")
                .addTopping("Champiñón")
                .addTopping("Extra queso")
                .build();

        System.out.println(pizza);
        // Pizza{size='Grande', toppings=[Peperoni, Champiñón, Extra queso]}
    }

}

class PizzaBuilder  {
    Pizza p = new Pizza();
    public PizzaBuilder withSize (String size){
        p.size = size;
        return this;
    }

    public PizzaBuilder addTopping(String topping){
        p.toppings.add(topping);
        return this;
    }

    public Pizza build(){
        return p;
    }

}
