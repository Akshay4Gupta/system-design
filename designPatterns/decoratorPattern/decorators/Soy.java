package designPatterns.decoratorPattern.decorators;

import designPatterns.decoratorPattern.Beverage;
import designPatterns.decoratorPattern.Condiments;

public class Soy extends Condiments {
    public Soy(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        return 0.15 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", soy";
    }
}
