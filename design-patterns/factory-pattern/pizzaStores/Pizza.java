package designPatterns.factoryPattern.pizzaStores;

public abstract class Pizza {
    protected abstract void prepare();
    protected abstract void bake();
    protected abstract void cut();
    protected abstract void box();

    public void parcel() {

    }
}
