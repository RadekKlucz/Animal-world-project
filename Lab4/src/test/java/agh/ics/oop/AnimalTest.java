package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class AnimalTest {

    @Test
    void checkDefaultPosition() {
        // given
        var map = new RectangularMap(5, 5);
        var animal = new Animal(map);
        var expectedPosition = new Vector2d(2, 2);
        var expectedDirection = MapDirection.NORTH;
        // when
        var actualPosition = animal.getPosition();
        var actualDirection = animal.getDirection();
        // test
        assertEquals(expectedPosition, actualPosition);
        assertEquals(expectedDirection, actualDirection);
    }

    @Test
    void testAnotherPosition() {
        // given
        var map = new RectangularMap(5, 5);
        var newDefaultPosition = new Vector2d(3, 3);
        var animal = new Animal(map, newDefaultPosition);
        // when
        var actualPosition = animal.getPosition();
        // test
        assertEquals(newDefaultPosition, actualPosition);
    }

    @Test
    void testIllegalPosition() {
        // given
        var map = new RectangularMap(5, 5);
        var illegalPosition = new Vector2d(5, 5);
        // test
        assertThrows(IllegalArgumentException.class, () -> new Animal(map, illegalPosition));
    }

    @Test
    void testGetDirection() {
        // given
        var map = new RectangularMap(5, 5);
        var animal = new Animal(map);
        var expectedDirection = MapDirection.NORTH;
        // when
        var actualDirection = animal.getDirection();
        // test
        assertEquals(expectedDirection, actualDirection);
    }

    @Test
    void testToStringNorth() {
        // given
        var map = new RectangularMap(5, 5);
        var animal = new Animal(map);
        var expectedString = "N";
        // when
        var actualString = animal.toString();
        // test
        assertEquals(expectedString, actualString);
    }

    @Test
    void testToStringEast() {
        // given
        var map = new RectangularMap(5, 5);
        var animal = new Animal(map);
        var expectedString = "E";
        // when
        animal.move(MoveDirection.RIGHT);
        var actualString = animal.toString();
        // test
        assertEquals(expectedString, actualString);
    }

    @Test
    void testToStringWest() {
        // given
        var map = new RectangularMap(5, 5);
        var animal = new Animal(map);
        var expectedString = "W";
        // when
        animal.move(MoveDirection.LEFT);
        var actualString = animal.toString();
        // test
        assertEquals(expectedString, actualString);
    }

    @Test
    void testToStringSouth() {
        // given
        var map = new RectangularMap(5, 5);
        var animal = new Animal(map);
        var expectedString = "S";
        // when
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.LEFT);
        var actualString = animal.toString();
        // test
        assertEquals(expectedString, actualString);
    }

    @Test
    void testMove() {
        // given
        var map = new RectangularMap(5, 5);
        var animal = new Animal(map);
        var expectedDirection = MapDirection.NORTH;
        var expectedPosition = new Vector2d(0, 2);
        // when
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.RIGHT);
        var actualDirection = animal.getDirection();
        var actualPosition = animal.getPosition();
        // test
        assertEquals(expectedDirection, actualDirection);
        assertEquals(expectedPosition, actualPosition);
    }

    @Test
    void IllegalMoves() {
        // given
        var map = new RectangularMap(5, 5);
        var animal = new Animal(map);
        var expectedDirection = MapDirection.EAST;
        var expectedPosition = new Vector2d(4, 2);
        // when
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        var actualDirection = animal.getDirection();
        var actualPosition = animal.getPosition();
        // test
        assertEquals(expectedDirection, actualDirection);
        assertEquals(expectedPosition, actualPosition);
    }
}
