package designPatterns.decoratorPattern.beverages;

import designPatterns.decoratorPattern.Beverage;

public class DarkRoast extends Beverage {
    public DarkRoast() {
        this.description = "Dark Roast";
    }

    @Override
    public double cost() {
        return 0.99;
    }
}
