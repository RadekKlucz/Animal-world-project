//package agh.ics.oop;
//
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//public class RectangularMapTest {
//
//    @Test
//    void testCanMoveToEmptyCell() {
//        // given
//        var map = new RectangularMap(4, 4);
//        var position = new Vector2d(2, 2);
//        // when
//        var ifTrue = map.canMoveTo(position);
//        // test
//        assertTrue(ifTrue);
//    }
//
//    @Test
//    void testCanMoveToOutOfRange() {
//        // given
//        var map = new RectangularMap(4, 4);
//        var position = new Vector2d(3, 5);
//        // when
//        var ifFalse = map.canMoveTo(position);
//        // test
//        assertFalse(ifFalse);
//    }
//
//    @Test
//    void testCanMoveToOccupiedCell() {
//        // given
//        var map = new RectangularMap(4, 4);
//        new Animal(map);
//        var position = new Vector2d(2, 2);
//        // when
//        var ifFalse = map.canMoveTo(position);
//        // test
//        assertFalse(ifFalse);
//    }
//
//    @Test
//    void testPaceAnimalOutOfRange() {
//        // given
//        var map = new RectangularMap(4, 4);
//        var position = new Vector2d(5,6);
//        // test
//        assertThrows(IllegalArgumentException.class, () -> new Animal(map, position));
//    }
//
//    @Test
//    void testPlaceTwoAnimalsInOneCell() {
//        // given
//        var map = new RectangularMap(4, 4);
//        new Animal(map);
//        // test
//        assertThrows(IllegalArgumentException.class, () -> new Animal(map));
//    }
//
//    @Test
//    void testIsOccupiedFalse() {
//        // given
//        var map = new RectangularMap(5, 5);
//        var position = new Vector2d(2, 2);
//        // test
//        assertFalse(map.isOccupied(position));
//    }
//
//    @Test
//    void testIsOccupiedTrue() {
//        // given
//        var map = new RectangularMap(4, 4);
//        var position = new Vector2d(2, 2);
//        new Animal(map);
//        // test
//        assertTrue(map.isOccupied(position));
//    }
//
//    @Test
//    void testIsOccupiedOutOfIndex() {
//        // given
//        var map = new RectangularMap(5, 5);
//        var position = new Vector2d(6, 4);
//        // test
//        assertFalse(map.isOccupied(position));
//    }
//}
