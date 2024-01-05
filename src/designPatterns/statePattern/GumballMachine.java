package designPatterns.statePattern;

import designPatterns.statePattern.states.HasQuarterState;
import designPatterns.statePattern.states.NoQuarterState;
import designPatterns.statePattern.states.SoldOutState;
import designPatterns.statePattern.states.SoldState;

public class GumballMachine {
    State hasQuarterState;
    State noQuarterState;
    State soldState;
    State soldOutState;

    State state;
    int numberOfGumballs = 0;

    public GumballMachine(int numberOfGumballs) {
        hasQuarterState = new HasQuarterState(this);
        noQuarterState = new NoQuarterState(this);
        soldState = new SoldState(this);
        soldOutState = new SoldOutState(this);

        this.numberOfGumballs = numberOfGumballs;
        if (numberOfGumballs > 0) {
            state = noQuarterState;
        } else {
            state = soldOutState;
        }
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectsQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        if (state.turnCrank())
            state.dispense();
    }

    public void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (numberOfGumballs > 0) --numberOfGumballs;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public int getNumberOfGumballs() {
        return numberOfGumballs;
    }

    public void setState(State state) {
        this.state = state;
    }
}
