package designPatterns.statePattern.states;

import designPatterns.statePattern.GumballMachine;
import designPatterns.statePattern.State;

public class HasQuarterState implements State {
    GumballMachine gumballMachine;

    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public boolean insertQuarter() {
        System.out.println("You can't insert another quarter");
        return false;
    }

    @Override
    public boolean ejectQuarter() {
        System.out.println("Quarter returned");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
        return true;
    }

    @Override
    public boolean turnCrank() {
        System.out.println("You turned...");
        gumballMachine.setState(gumballMachine.getSoldState());
        return true;
    }

    @Override
    public boolean dispense() {
        System.out.println("No gumball dispensed");
        return false;
    }
}
