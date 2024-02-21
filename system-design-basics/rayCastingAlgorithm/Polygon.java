package systemDesignBasics.rayCastingAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Polygon {
    List<Point> points;
    List<List<Point>> edges;

    public Polygon(List<Point> points) {
        this.points = points;
    }

    public List<List<Point>> edges() {
        if (Objects.nonNull(edges)) return edges;

        List<List<Point>> edgeList = new ArrayList<>();
        for(int i = 0; i < points.size(); i++) {
            Point A = points.get(i);
            Point B = points.get((i + 1) % points.size());
            if (A.getY() < B.getY()) {
                edgeList.add(new ArrayList<>(Arrays.asList(A, B)));
            } else {
                edgeList.add(new ArrayList<>(Arrays.asList(B, A)));
            }
        }
        this.edges = edgeList;
        return edgeList;
    }

    double angle(Point point1, Point point2) {
        try {
            return (point2.getY() - point1.getY()) / (point2.getX() - point1.getX());
        } catch (ArithmeticException e) {
            return Integer.MAX_VALUE;
        }
    }

    public boolean contains(Point point) {
        List<List<Point>> edges = edges();

        boolean isInside = false;
        for(List<Point> edge: edges) {
            if (point.getY() == edge.get(1).getY() || point.getY() == edge.get(0).getY()) {
                point.setY(point.getY() + 0.000001);
            }
            if (point.getY() > edge.get(1).getY() || point.getY() < edge.get(0).getY() || point.getX() > Math.max(edge.get(1).getX(),
                    edge.get(0).getX())) {
                continue;
            }
            if (point.getX() < Math.min(edge.get(1).getX(),
                    edge.get(0).getX())) {
                isInside = !isInside;
                continue;
            }

            double angle1 = angle(point, edge.get(0));
            double angle2 = angle(edge.get(1), edge.get(0));
            if (angle1 >= angle2) {
                isInside = !isInside;
            }
        }
        return isInside;
    }
}
