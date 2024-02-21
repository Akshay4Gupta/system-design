package designPatterns.factoryPattern.abstractFactoryMethod.pizzaStores;

import designPatterns.factoryPattern.abstractFactoryMethod.Pizza;
import designPatterns.factoryPattern.abstractFactoryMethod.PizzaIngredients;
import designPatterns.factoryPattern.abstractFactoryMethod.PizzaStore;
import designPatterns.factoryPattern.abstractFactoryMethod.PizzaType;
import designPatterns.factoryPattern.abstractFactoryMethod.pizza.CheesePizza;
import designPatterns.factoryPattern.abstractFactoryMethod.pizza.ClamPizza;
import designPatterns.factoryPattern.abstractFactoryMethod.pizza.PepperoniPizza;
import designPatterns.factoryPattern.abstractFactoryMethod.pizza.VeggiePizza;
import designPatterns.factoryPattern.abstractFactoryMethod.pizzaIngredients.NyPizzaIngredientFactory;

public class NyPizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(PizzaType pizzaType) {
        PizzaIngredients pizzaIngredients = new NyPizzaIngredientFactory();
        Pizza pizza = null;
        if (pizzaType.equals(PizzaType.CHEESE)) {
            pizza = new CheesePizza(pizzaIngredients);
            pizza.setName("New York Style Cheese Pizza");
        } else if (pizzaType.equals(PizzaType.CLAM)) {
            pizza = new ClamPizza(pizzaIngredients);
            pizza.setName("New York Style Clam Pizza");
        } else if (pizzaType.equals(PizzaType.PEPPERONI)) {
            pizza = new PepperoniPizza(pizzaIngredients);
            pizza.setName("New York Style Pepperoni Pizza");
        } else if (pizzaType.equals(PizzaType.VEGGIE)) {
            pizza = new VeggiePizza(pizzaIngredients);
            pizza.setName("New York Style Veggie Pizza");
        }
        return pizza;
    }
}
