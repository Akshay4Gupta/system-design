package designPatterns.iteratorAndCompositePattern.IteratorPattern;

import designPatterns.iteratorAndCompositePattern.IteratorPattern.menus.DinerMenu;
import designPatterns.iteratorAndCompositePattern.IteratorPattern.menus.PancakeHouseMenu;

import java.util.HashMap;
import java.util.Map;

public class MenuTestDrive {
    public static void main(String args[]) {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        DinerMenu dinerMenu = new DinerMenu();

        Map<String, Menu> menuList = new HashMap<>();
        menuList.put("dinerMenu", dinerMenu);
        menuList.put("pancakeHouseMenu", pancakeHouseMenu);

        Waitress waitress = new Waitress(menuList);
        waitress.printMenu();
    }
}
