package designPatterns.factoryPattern.pizzaStores;

import designPatterns.factoryPattern.pizzaStores.clients.NYStylePizzaStore;

public class Main {
    public static void main(String[] args) {
        String choice = "";
        PizzaStore pizzaStore = new NYStylePizzaStore();
        Pizza pizza = pizzaStore.orderPizza(choice);
    }
}
