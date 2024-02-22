package designPatterns.iteratorAndCompositePattern.compositePattern.iterator;

import designPatterns.iteratorAndCompositePattern.compositePattern.MenuComponent;

import java.util.Iterator;

public class NullIterator implements Iterator<MenuComponent> {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public MenuComponent next() {
        return null;
    }
}
