package designPatterns.observerPattern;

/**
 * observable
 */
public interface ObservableStation {

    void addScreen(ObserverScreen screen);
    void deleteScreen(ObserverScreen screen);
    void notifyAllScreens();
}