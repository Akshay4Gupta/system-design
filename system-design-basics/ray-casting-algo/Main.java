package systemDesignBasics.rayCastingAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Point> points = new ArrayList<>(Arrays.asList(
                new Point(20, 10),
                new Point(50, 125),
                new Point(125, 90),
                new Point(150, 10)
        ));
        Polygon q = new Polygon(points);

//    # Test 1: Point inside of polygon
        Point p1 = new Point(75, 50);
        System.out.println("P1 inside polygon: " + q.contains(p1));

//    # Test 2: Point outside of polygon
        Point p2 = new Point(200, 50);
        System.out.println("P2 inside polygon: " + q.contains(p2));

//    # Test 3: Point at same height as vertex
        Point p3 = new Point(35, 90);
        System.out.println("P3 inside polygon: " + q.contains(p3));

//    # Test 4: Point on bottom line of polygon
        Point p4 = new Point(50, 10);
        System.out.println("P4 inside polygon: " + q.contains(p4));
    }
}
