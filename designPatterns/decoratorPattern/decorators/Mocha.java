package designPatterns.decoratorPattern.decorators;

import designPatterns.decoratorPattern.Beverage;
import designPatterns.decoratorPattern.Condiments;

public class Mocha extends Condiments {
    public Mocha(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        return 0.20 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", mocha";
    }
}
