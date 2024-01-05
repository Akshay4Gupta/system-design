package designPatterns.factoryPattern.abstractFactoryMethod.pizza;

import designPatterns.factoryPattern.abstractFactoryMethod.Pizza;
import designPatterns.factoryPattern.abstractFactoryMethod.PizzaIngredients;

public class CheesePizza extends Pizza {
    PizzaIngredients pizzaIngredients;
    public CheesePizza(PizzaIngredients pizzaIngredients) {
        this.pizzaIngredients = pizzaIngredients;
    }

    @Override
    protected void prepare() {
        System.out.println("Preparing " + name);
        dough = pizzaIngredients.createDough();
        sauce = pizzaIngredients.createSauce();
        cheese = pizzaIngredients.createCheese();
    }
}
