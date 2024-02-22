package designPatterns.iteratorAndCompositePattern.compositePattern.iterator;

import designPatterns.iteratorAndCompositePattern.compositePattern.Menu;
import designPatterns.iteratorAndCompositePattern.compositePattern.MenuComponent;

import java.util.Iterator;
import java.util.Stack;

public class CompositeIterator implements Iterator<MenuComponent> {
    Stack<Iterator<MenuComponent>> stack;

    public CompositeIterator(Iterator<MenuComponent> iterator) {
        stack = new Stack<>();
        stack.push(iterator);
    }

    @Override
    public boolean hasNext() {
        while (!stack.empty() && !stack.peek().hasNext()) {
            stack.pop();
        }
        if (stack.empty()) return false;
        return stack.peek().hasNext();
    }

    @Override
    public MenuComponent next() {
        if (hasNext()) {
            Iterator<MenuComponent> iterator = stack.peek();
            MenuComponent menuComponent = iterator.next();
            if (menuComponent instanceof Menu) {
                stack.push(menuComponent.iterator());
            }
            return menuComponent;
        }
        return null;
    }
}
