package designPatterns.factoryPattern.pizzaStores.clients;

import designPatterns.factoryPattern.pizzaStores.Pizza;
import designPatterns.factoryPattern.pizzaStores.PizzaStore;
import designPatterns.factoryPattern.pizzaStores.pizzas.nyStyle.NYStyleCheesePizza;
import designPatterns.factoryPattern.pizzaStores.pizzas.nyStyle.NYStyleClamPizza;
import designPatterns.factoryPattern.pizzaStores.pizzas.nyStyle.NYStylePepperoniPizza;
import designPatterns.factoryPattern.pizzaStores.pizzas.nyStyle.NYStyleVeggiePizza;

public class NYStylePizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new NYStyleCheesePizza();
        } else if (type.equals("pepperoni")) {
            pizza = new NYStylePepperoniPizza();
        } else if (type.equals("clam")) {
            pizza = new NYStyleClamPizza();
        } else if (type.equals("veggie")) {
            pizza = new NYStyleVeggiePizza();
        }
        return pizza;
    }
}
