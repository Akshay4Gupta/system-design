package designPatterns.factoryPattern.abstractFactoryMethod;

import designPatterns.factoryPattern.abstractFactoryMethod.ingredients.Cheese;
import designPatterns.factoryPattern.abstractFactoryMethod.ingredients.Clam;
import designPatterns.factoryPattern.abstractFactoryMethod.ingredients.Dough;
import designPatterns.factoryPattern.abstractFactoryMethod.ingredients.Pepperoni;
import designPatterns.factoryPattern.abstractFactoryMethod.ingredients.Sauce;
import designPatterns.factoryPattern.abstractFactoryMethod.ingredients.Veggie;

public abstract class PizzaIngredients {
    public abstract Dough createDough();
    public abstract Sauce createSauce();
    public abstract Cheese createCheese();
    public abstract Veggie[] createVeggies();
    public abstract Pepperoni createPepperoni();
    public abstract Clam createClam();
}
