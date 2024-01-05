package designPatterns.factoryPattern.abstractFactoryMethod.pizzaIngredients;

import designPatterns.factoryPattern.abstractFactoryMethod.PizzaIngredients;
import designPatterns.factoryPattern.abstractFactoryMethod.ingredients.Cheese;
import designPatterns.factoryPattern.abstractFactoryMethod.ingredients.Clam;
import designPatterns.factoryPattern.abstractFactoryMethod.ingredients.Dough;
import designPatterns.factoryPattern.abstractFactoryMethod.ingredients.Pepperoni;
import designPatterns.factoryPattern.abstractFactoryMethod.ingredients.Sauce;
import designPatterns.factoryPattern.abstractFactoryMethod.ingredients.Veggie;
import designPatterns.factoryPattern.abstractFactoryMethod.ingredients.cheese.ReggianoCheese;
import designPatterns.factoryPattern.abstractFactoryMethod.ingredients.clam.FreshClams;
import designPatterns.factoryPattern.abstractFactoryMethod.ingredients.dough.ThinCrustDough;
import designPatterns.factoryPattern.abstractFactoryMethod.ingredients.pepperoni.SlicedPepperoni;
import designPatterns.factoryPattern.abstractFactoryMethod.ingredients.sauce.MarinaraSauce;
import designPatterns.factoryPattern.abstractFactoryMethod.ingredients.veggies.Garlic;
import designPatterns.factoryPattern.abstractFactoryMethod.ingredients.veggies.Mushroom;
import designPatterns.factoryPattern.abstractFactoryMethod.ingredients.veggies.Onion;

public class NyPizzaIngredientFactory extends PizzaIngredients {
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Veggie[] createVeggies() {
        return new Veggie[]{new Garlic(), new Onion(), new Mushroom()};
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clam createClam() {
        return new FreshClams();
    }
}
