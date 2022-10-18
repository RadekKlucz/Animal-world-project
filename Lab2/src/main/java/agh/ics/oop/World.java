package agh.ics.oop;

import java.util.Arrays;

import static java.lang.System.out;

public class World {
    public static void main(String[] args) {
        Vector2d position1 = new Vector2d(1, 2);
        out.println(position1);
        out.println(position1.toString());

        Vector2d position2 = new Vector2d(-2, 1);
        out.println(position2);
        out.println(position1.add(position2));

        Vector2d a = new Vector2d(2, 5);
        Vector2d b = new Vector2d(4, 3);
//        out.println(a.precedes(b));
//        out.println(a.upperRight(b));
//        out.println(b.lowerLeft(a));
//        out.println(a.subtract(b));
//        out.println(a.follows(b));
//        out.println(a.opposite());
//        out.println(a.equals(b));

        Vector2d.MapDirection map = Vector2d.MapDirection.WEST;
        out.println(map.previous());
        out.println(map.next());
        out.println(map.toString());
        out.println(Arrays.toString(map.toUnitVector()));
    }
}