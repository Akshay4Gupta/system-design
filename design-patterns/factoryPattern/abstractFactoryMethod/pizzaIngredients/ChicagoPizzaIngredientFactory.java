package designPatterns.factoryPattern.abstractFactoryMethod.pizzaIngredients;

import designPatterns.factoryPattern.abstractFactoryMethod.PizzaIngredients;
import designPatterns.factoryPattern.abstractFactoryMethod.ingredients.Cheese;
import designPatterns.factoryPattern.abstractFactoryMethod.ingredients.Clam;
import designPatterns.factoryPattern.abstractFactoryMethod.ingredients.Dough;
import designPatterns.factoryPattern.abstractFactoryMethod.ingredients.Pepperoni;
import designPatterns.factoryPattern.abstractFactoryMethod.ingredients.Sauce;
import designPatterns.factoryPattern.abstractFactoryMethod.ingredients.Veggie;
import designPatterns.factoryPattern.abstractFactoryMethod.ingredients.cheese.MozzarellaCheese;
import designPatterns.factoryPattern.abstractFactoryMethod.ingredients.clam.FrozenClams;
import designPatterns.factoryPattern.abstractFactoryMethod.ingredients.dough.ThickCrustDough;
import designPatterns.factoryPattern.abstractFactoryMethod.ingredients.pepperoni.SlicedPepperoni;
import designPatterns.factoryPattern.abstractFactoryMethod.ingredients.sauce.PlumTomatoSauce;
import designPatterns.factoryPattern.abstractFactoryMethod.ingredients.veggies.BlackOlives;
import designPatterns.factoryPattern.abstractFactoryMethod.ingredients.veggies.Eggplant;
import designPatterns.factoryPattern.abstractFactoryMethod.ingredients.veggies.Spinach;

public class ChicagoPizzaIngredientFactory extends PizzaIngredients {
    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }

    @Override
    public Cheese createCheese() {
        return new MozzarellaCheese();
    }

    @Override
    public Veggie[] createVeggies() {
        return new Veggie[]{new BlackOlives(), new Spinach(), new Eggplant()};
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clam createClam() {
        return new FrozenClams();
    }
}
