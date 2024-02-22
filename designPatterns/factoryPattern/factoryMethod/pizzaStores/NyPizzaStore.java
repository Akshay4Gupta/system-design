package designPatterns.factoryPattern.factoryMethod.pizzaStores;

import designPatterns.factoryPattern.factoryMethod.Pizza;
import designPatterns.factoryPattern.factoryMethod.PizzaStore;
import designPatterns.factoryPattern.factoryMethod.PizzaType;
import designPatterns.factoryPattern.factoryMethod.pizza.NyPizza.CheesePizza;
import designPatterns.factoryPattern.factoryMethod.pizza.NyPizza.ClamPizza;
import designPatterns.factoryPattern.factoryMethod.pizza.NyPizza.PepperoniPizza;
import designPatterns.factoryPattern.factoryMethod.pizza.NyPizza.VeggiePizza;

public class NyPizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(PizzaType pizzaType) {
        if (pizzaType.equals(PizzaType.CHEESE)) {
            return new CheesePizza();
        } else if (pizzaType.equals(PizzaType.CLAM)) {
            return new ClamPizza();
        } else if (pizzaType.equals(PizzaType.PEPPERONI)) {
            return new PepperoniPizza();
        } else if (pizzaType.equals(PizzaType.VEGGIE)) {
            return new VeggiePizza();
        }
        return null;
    }
}
