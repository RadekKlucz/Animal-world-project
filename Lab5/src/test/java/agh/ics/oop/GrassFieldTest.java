package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest {

    @Test
    void testCanMoveTo() {
        // given
        GrassField map = new GrassField(15);
        var position1 = new Vector2d(3, 3);
        var position2 = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
        var position3 = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        var animal = new Animal(map, new Vector2d(4, 2));
        // when
        var move = map.canMoveTo(position1);
        var move2 = map.canMoveTo(position2);
        var move3 = map.canMoveTo(position3);
        // then
        assertTrue(move);
        assertTrue(move2);
        assertTrue(move3);
    }

    @Test
    void testMoveToEmptyCell() {
        // given
        var position = new Vector2d(2, 2);
        var map = new GrassField(10);
        // then
        assertTrue(map.canMoveTo(position));
    }

    @Test
    void testTwoAnimalsOnePlace() {
        // given
        var map = new GrassField(10);
        new Animal(map);
        // then
        assertThrows(IllegalArgumentException.class, () -> new Animal(map));
    }

    @Test
    void testRightPlaceOfAnimal() {
        // given
        var map = new GrassField(10);
        // then
        assertDoesNotThrow(() -> new Animal(map));
    }

    @Test
    void testIsOccupiedFalse() {
        // given
        var map = new GrassField(10);
        var position = new Vector2d(2, 2);
        // when
        assertFalse(map.isOccupied(position));
    }
}
