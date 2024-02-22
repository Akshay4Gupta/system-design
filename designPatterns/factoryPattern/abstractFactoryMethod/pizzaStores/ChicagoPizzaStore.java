package designPatterns.factoryPattern.abstractFactoryMethod.pizzaStores;

import designPatterns.factoryPattern.abstractFactoryMethod.Pizza;
import designPatterns.factoryPattern.abstractFactoryMethod.PizzaIngredients;
import designPatterns.factoryPattern.abstractFactoryMethod.PizzaStore;
import designPatterns.factoryPattern.abstractFactoryMethod.PizzaType;
import designPatterns.factoryPattern.abstractFactoryMethod.pizza.CheesePizza;
import designPatterns.factoryPattern.abstractFactoryMethod.pizza.ClamPizza;
import designPatterns.factoryPattern.abstractFactoryMethod.pizza.PepperoniPizza;
import designPatterns.factoryPattern.abstractFactoryMethod.pizza.VeggiePizza;
import designPatterns.factoryPattern.abstractFactoryMethod.pizzaIngredients.ChicagoPizzaIngredientFactory;

public class ChicagoPizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(PizzaType pizzaType) {
        PizzaIngredients pizzaIngredients = new ChicagoPizzaIngredientFactory();
        if (pizzaType.equals(PizzaType.CHEESE)) {
            return new CheesePizza(pizzaIngredients);
        } else if (pizzaType.equals(PizzaType.CLAM)) {
            return new ClamPizza(pizzaIngredients);
        } else if (pizzaType.equals(PizzaType.PEPPERONI)) {
            return new PepperoniPizza(pizzaIngredients);
        } else if (pizzaType.equals(PizzaType.VEGGIE)) {
            return new VeggiePizza(pizzaIngredients);
        }
        return null;
    }
}
