package designPatterns.iteratorAndCompositePattern.IteratorPattern.iterators;

import designPatterns.iteratorAndCompositePattern.IteratorPattern.MenuItem;

import java.util.Iterator;
import java.util.List;

public class PancakeHouseMenuIterator implements Iterator<MenuItem> {
    List<MenuItem> menuItems;
    int position;

    public PancakeHouseMenuIterator(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < menuItems.size();
    }

    @Override
    public MenuItem next() {
        return menuItems.get(position++);
    }
}
