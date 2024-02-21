package designPatterns.factoryPattern.factoryMethod;

import designPatterns.factoryPattern.factoryMethod.pizzaStores.NyPizzaStore;

public class Main {
    public static void main(String[] args) {
        PizzaStore pizzaStore = new NyPizzaStore();
        Pizza pizza = pizzaStore.orderPizza(PizzaType.CHEESE);
        pizza.parcel();
    }
}
