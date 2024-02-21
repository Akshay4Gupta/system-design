package designPatterns.decoratorPattern.decorators;

import designPatterns.decoratorPattern.Beverage;
import designPatterns.decoratorPattern.Condiments;

public class Whip extends Condiments {
    public Whip(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        return 0.10 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", whipped";
    }
}
