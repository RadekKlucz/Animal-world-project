package agh.ics.oop;

import java.util.Comparator;

public class MapBoundaryComparison implements Comparator<Vector2d> {
    private final String axis;

    public MapBoundaryComparison(String axis) {
        this.axis = axis;
    }

    public int compare(Vector2d firstPosition, Vector2d secondPosition) {
        if(axis.equals("x")) {
            if(firstPosition == secondPosition) {
                return Integer.compare(firstPosition.y, secondPosition.y);
            } else {
                return Integer.compare(firstPosition.x, secondPosition.x);
            }
        } else {
            if(firstPosition == secondPosition) {
                return Integer.compare(firstPosition.x, secondPosition.x);
            } else {
                return Integer.compare(firstPosition.y, secondPosition.y);
            }
        }
    }
}
