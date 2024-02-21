package designPatterns.factoryPattern.abstractFactoryMethod;

import designPatterns.factoryPattern.abstractFactoryMethod.pizzaStores.NyPizzaStore;

public class Main {
    public static void main(String[] args) {
        PizzaStore pizzaStore = new NyPizzaStore();
        Pizza pizza = pizzaStore.orderPizza(PizzaType.CHEESE);
        pizza.parcel();
    }
}
