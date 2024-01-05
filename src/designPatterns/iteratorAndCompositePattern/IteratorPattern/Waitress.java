package designPatterns.iteratorAndCompositePattern.IteratorPattern;

import java.util.Iterator;
import java.util.Map;

public class Waitress {
    Map<String, Menu> menuList;

    public Waitress(Map<String, Menu> menuList) {
        this.menuList = menuList;
    }

    public void printMenu() {
        System.out.println("Menu\n----");
        for (Map.Entry<String, Menu> menuEntry : menuList.entrySet()) {
            System.out.println('\n' + menuEntry.getKey());
            Menu menu = menuEntry.getValue();
            Iterator<MenuItem> iterator = menu.iterator();
            printMenu(iterator);
        }
    }

    public void printMenu(Iterator<MenuItem> iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = iterator.next();
            System.out.print(menuItem.getName() + ", ");
            System.out.print(menuItem.getPrice() + " -- ");
            System.out.println(menuItem.getDescription());
//            System.out.println(iterator.next());
        }
    }
}
