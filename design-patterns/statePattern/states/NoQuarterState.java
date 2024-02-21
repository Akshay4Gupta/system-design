package designPatterns.statePattern.states;

import designPatterns.statePattern.GumballMachine;
import designPatterns.statePattern.State;

public class NoQuarterState implements State {
    GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public boolean insertQuarter() {
        System.out.println("You inserted a quarter");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
        return true;
    }

    @Override
    public boolean ejectQuarter() {
        System.out.println("You haven't inserted a quarter");
        return false;
    }

    @Override
    public boolean turnCrank() {
        System.out.println("You turned but there's no quarter");
        return false;
    }

    @Override
    public boolean dispense() {
        System.out.println("You need to pay first");
        return false;
    }
}
