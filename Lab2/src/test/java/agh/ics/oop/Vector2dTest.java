package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Vector2dTest {
    Vector2d object1 = new Vector2d(1, 2);
    Vector2d object2 = new Vector2d(-2, 1);
    Vector2d object3 = new Vector2d(2, 5);
    Vector2d object4 = new Vector2d(4, 3);



    @Test
    void checkEquals() {
        assertFalse(object1.equals(object2));
    }

    @Test
    void checkToString() {
        String values = "(1, 2)";
        assertEquals(values, object1.toString());
    }

    @Test
    void checkPrecedes() {
        assertFalse(object3.precedes(object4));
    }

    @Test
    void checkFollows() {
        assertFalse(object3.follows(object4));
    }

    @Test
    void checkUpperRight() {
//      O co chodzi ze innym dziala a mi nie? No nie lubie tej javy
        Vector2d objectA = new Vector2d(2, 5);
        Vector2d objectB = new Vector2d(4, 3);
        Vector2d objectC = new Vector2d(4, 5);
        assertEquals(objectC, objectA.upperRight(objectB));
    }

    @Test
    void checkLowerLeft() {
        assertEquals(new Vector2d(2, 3), object3.lowerLeft(object4));
    }

    @Test
    void checkAdd() {
        assertEquals(new Vector2d(6, 8), object3.add(object4));
    }

    @Test
    void checkSubtract() {
        assertEquals(new Vector2d(-1, 2), object3.subtract(object4));
    }

    @Test
    void checkOpposite() {
        assertEquals(new Vector2d(-2, -5), object3.opposite());
    }
}
