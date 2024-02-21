package designPatterns.decoratorPattern;

public abstract class Condiments extends Beverage {
    protected Beverage beverage;

    public Condiments (Beverage beverage) {
        this.beverage = beverage;
    }

    public abstract String getDescription();
}
