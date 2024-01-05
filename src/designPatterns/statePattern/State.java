package designPatterns.statePattern;

public interface State {
    boolean insertQuarter();
    boolean ejectQuarter();
    boolean turnCrank();
    boolean dispense();
}
