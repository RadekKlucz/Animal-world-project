package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapDirectionTest {
    Vector2d.MapDirection map = Vector2d.MapDirection.WEST;
    Vector2d.MapDirection map1 = Vector2d.MapDirection.EAST;
    Vector2d.MapDirection map2 = Vector2d.MapDirection.NORTH;
    Vector2d.MapDirection map3 = Vector2d.MapDirection.SOUTH;

    @Test
    void checkIfNextIsOkForMap() {
        assertEquals(map, map.next());
    }

    @Test
    void checkIfNextIsOkForMap1() {
        assertEquals(map, map1.next());
    }

    @Test
    void checkIfNextIsOkForMap2() {
        assertEquals(map, map2.next());
    }

    @Test
    void checkIfNextIsOkForMap3() {
        assertEquals(map, map3.next());
    }

    @Test
    void checkIfPreviousIsOk() {
        assertEquals(map2, map.previous());
    }

    @Test
    void checkIfPreviousIsOk1() {
        assertEquals(map2, map1.previous());
    }

    @Test
    void checkIfPreviousIsOk2() {
        assertEquals(map2, map2.previous());
    }

    @Test
    void checkIfPreviousIsOk3() {
        assertEquals(map2, map3.previous());
    }
}
