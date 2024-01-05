package designPatterns.adapterAndFacadePattern;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        EnumerationIterator enumerationIterator = new EnumerationIterator(arrayList.iterator());
        if (enumerationIterator.hasMoreElements()) {
            System.out.println(enumerationIterator.nextElement());
        }
    }
}
