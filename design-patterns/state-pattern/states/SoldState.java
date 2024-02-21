package designPatterns.statePattern.states;

import designPatterns.statePattern.GumballMachine;
import designPatterns.statePattern.State;

public class SoldState implements State {
    GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public boolean insertQuarter() {
        System.out.println("Please wait, we're already giving you a gumball");
        return false;
    }

    @Override
    public boolean ejectQuarter() {
        System.out.println("Sorry, you already turned the crank");
        return false;
    }

    @Override
    public boolean turnCrank() {
        System.out.println("Turning twice doesn't get you another gumball!");
        return false;
    }

    @Override
    public boolean dispense() {
        System.out.println("A gumball comes rolling out the slot");
        gumballMachine.releaseBall();
        if (gumballMachine.getNumberOfGumballs() > 0) {
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        } else {
            System.out.println("Oops, out of gumballs!");
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
        return true;
    }
}
