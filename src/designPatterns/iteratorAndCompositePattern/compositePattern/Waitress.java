package designPatterns.iteratorAndCompositePattern.compositePattern;

import java.util.Iterator;

public class Waitress {
    MenuComponent allMenus;
    Waitress(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    public void printMenu() {
        allMenus.print();
    }

    public void printVegetarianMenu() {
        Iterator<MenuComponent> iterator = allMenus.iterator();
        System.out.println("\nVEGETARIAN MENU\n----");
        while(iterator.hasNext()) {
            MenuComponent menuComponent = iterator.next();
            try {
                if(menuComponent.isVegetarian()) {
                    menuComponent.print();
                }
            } catch (UnsupportedOperationException ignore) {}
        }
    }
}
