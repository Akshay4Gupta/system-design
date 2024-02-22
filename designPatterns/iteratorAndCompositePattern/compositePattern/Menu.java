package designPatterns.iteratorAndCompositePattern.compositePattern;

import designPatterns.iteratorAndCompositePattern.compositePattern.iterator.CompositeIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Menu extends MenuComponent {
    String name;
    String description;
    ArrayList<MenuComponent> menuComponents;
    Iterator<MenuComponent> iterator;

    Menu(String name, String description) {
        this.description = description;
        this.name = name;
        menuComponents = new ArrayList<>();
        iterator = null;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        menuComponent.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int i) {
        return menuComponents.get(i);
    }

    @Override
    public void print() {
        System.out.print("\n " + getName());
        System.out.println(", " + getDescription());
        System.out.println("----------------------");

        for (MenuComponent menuComponent : menuComponents) {
            menuComponent.print();
        }
    }

    @Override
    public Iterator<MenuComponent> iterator() {
        if (Objects.isNull(iterator)) {
            iterator = new CompositeIterator(menuComponents.iterator());
        }
        return iterator;
    }
}
