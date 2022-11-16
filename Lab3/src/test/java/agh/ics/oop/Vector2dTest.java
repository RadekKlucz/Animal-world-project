package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {
    // given
    Vector2d object1 = new Vector2d(1, 2);
    Vector2d object2 = new Vector2d(-2, 1);
    Vector2d object3 = new Vector2d(2, 5);
    Vector2d object4 = new Vector2d(4, 3);

    // when
    String values = "(1, 2)";
    Vector2d object5 = new Vector2d(4, 5);
    Vector2d object6 = new Vector2d(2, 3);
    Vector2d object7 = new Vector2d(6, 8);
    Vector2d object8 = new Vector2d(-1, 2);
    Vector2d object9 = new Vector2d(-2, -5);

    // tests
    @Test
    void checkEquals() {
        assertNotEquals(object1, object2);
    }

    @Test
    void checkToString() {
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
        assertEquals(object5, object3.upperRight(object4));
    }

    @Test
    void checkLowerLeft() {
        assertEquals(object6, object3.lowerLeft(object4));
    }

    @Test
    void checkAdd() {
        assertEquals(object7, object3.add(object4));
    }

    @Test
    void checkSubtract() {
        assertEquals(object8, object3.subtract(object4));
    }

    @Test
    void checkOpposite() {
        assertEquals(object9, object3.opposite());
    }

    @Test
    void checkEqualsMethod() {
        assertFalse(object1.equals(object2));
    }
}
