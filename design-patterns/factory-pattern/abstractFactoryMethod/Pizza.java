package designPatterns.factoryPattern.abstractFactoryMethod;

import designPatterns.factoryPattern.abstractFactoryMethod.ingredients.Cheese;
import designPatterns.factoryPattern.abstractFactoryMethod.ingredients.Clam;
import designPatterns.factoryPattern.abstractFactoryMethod.ingredients.Dough;
import designPatterns.factoryPattern.abstractFactoryMethod.ingredients.Pepperoni;
import designPatterns.factoryPattern.abstractFactoryMethod.ingredients.Sauce;
import designPatterns.factoryPattern.abstractFactoryMethod.ingredients.Veggie;

public abstract class Pizza {
    protected String name;
    protected Dough dough;
    protected Sauce sauce;
    protected Veggie[] veggies;
    protected Cheese cheese;
    protected Pepperoni pepperoni;
    protected Clam clam;
    protected abstract void prepare();
    protected void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }
    protected void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }
    protected void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }
    protected void parcel() {
        System.out.println("Your pizza has been parceled to your address");
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
