package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapDirectionTest {

    @Test
    void checkIfNextIsOkForWest() {
        // given
        var west = MapDirection.WEST;
        var north = MapDirection.NORTH;
        // when
        var expected = west.next();
        // test
        assertEquals(north, expected); }

    @Test
    void checkIfNextIsOkForEast() {
        // given
        var south = MapDirection.SOUTH;
        var east = MapDirection.EAST;
        // when
        var expected = east.next();
        // test
        assertEquals(south, expected);
    }

    @Test
    void checkIfNextIsOkForNorth() {
        // given
        var east = MapDirection.EAST;
        var north = MapDirection.NORTH;
        // when
        var expected = north.next();
        // test
        assertEquals(east, expected);
    }

    @Test
    void checkIfNextIsOkForSouth() {
        // given
        var south = MapDirection.SOUTH;
        var west = MapDirection.WEST;
        // when
        var expected = south.next();
        // test
        assertEquals(west, expected);
    }

    @Test
    void checkIfPreviousIsOkForWest() {
        // given
        var south = MapDirection.SOUTH;
        var west = MapDirection.WEST;
        // when
        var expected = west.previous();
        // test
        assertEquals(south, expected);
    }

    @Test
    void checkIfPreviousIsOkForEast() {
        // given
        var east = MapDirection.EAST;
        var north = MapDirection.NORTH;
        // when
        var expeceted = east.previous();
        // test
        assertEquals(north, expeceted);
    }

    @Test
    void checkIfPreviousIsOkForNorth() {
        // given
        var west = MapDirection.WEST;
        var north = MapDirection.NORTH;
        // when
        var expected = north.previous();
        // test
        assertEquals(west, expected);
    }

    @Test
    void checkIfPreviousIsOkForSouth() {
        // given
        var south = MapDirection.SOUTH;
        var east = MapDirection.EAST;
        // when
        var expected = south.previous();
        // test
        assertEquals(east, expected);
    }
}
