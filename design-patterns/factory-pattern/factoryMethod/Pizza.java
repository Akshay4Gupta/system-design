package designPatterns.factoryPattern.factoryMethod;

public abstract class Pizza {
    protected abstract void prepare();
    protected abstract void bake();
    protected abstract void cut();
    protected abstract void box();
    protected void parcel() {
        System.out.println("Your pizza has been parceled to your address");
    }
}
