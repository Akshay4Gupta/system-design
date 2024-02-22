package designPatterns.factoryPattern.pizzaStores.clients;

import designPatterns.factoryPattern.pizzaStores.Pizza;
import designPatterns.factoryPattern.pizzaStores.PizzaStore;
import designPatterns.factoryPattern.pizzaStores.pizzas.chicagoStyle.ChicagoStyleCheesePizza;
import designPatterns.factoryPattern.pizzaStores.pizzas.chicagoStyle.ChicagoStyleClamPizza;
import designPatterns.factoryPattern.pizzaStores.pizzas.chicagoStyle.ChicagoStylePepperoniPizza;
import designPatterns.factoryPattern.pizzaStores.pizzas.chicagoStyle.ChicagoStyleVeggiePizza;

public class ChicagoPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new ChicagoStyleCheesePizza();
        } else if (type.equals("pepperoni")) {
            pizza = new ChicagoStylePepperoniPizza();
        } else if (type.equals("clam")) {
            pizza = new ChicagoStyleClamPizza();
        } else if (type.equals("veggie")) {
            pizza = new ChicagoStyleVeggiePizza();
        }
        return pizza;
    }
}
