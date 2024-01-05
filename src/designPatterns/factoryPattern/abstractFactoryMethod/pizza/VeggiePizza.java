package designPatterns.factoryPattern.abstractFactoryMethod.pizza;

import designPatterns.factoryPattern.abstractFactoryMethod.Pizza;
import designPatterns.factoryPattern.abstractFactoryMethod.PizzaIngredients;

public class VeggiePizza extends Pizza {
    PizzaIngredients pizzaIngredients;
    public VeggiePizza(PizzaIngredients pizzaIngredients) {
        this.pizzaIngredients = pizzaIngredients;
    }
    @Override
    protected void prepare() {

    }

    @Override
    protected void bake() {

    }

    @Override
    protected void cut() {

    }

    @Override
    protected void box() {

    }
}
