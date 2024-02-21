package designPatterns.statePattern.states;

import designPatterns.statePattern.GumballMachine;
import designPatterns.statePattern.State;

public class SoldOutState implements State {
    GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public boolean insertQuarter() {
        System.out.println("You can't insert a quarter, the machine is sold out");
        return false;
    }

    @Override
    public boolean ejectQuarter() {
        System.out.println("You can't eject, you haven't inserted a quarter yet");
        return false;
    }

    @Override
    public boolean turnCrank() {
        System.out.println("You turned, but there are no gumballs");
        return false;
    }

    @Override
    public boolean dispense() {
        System.out.println("No gumball dispensed");
        return false;
    }
}
