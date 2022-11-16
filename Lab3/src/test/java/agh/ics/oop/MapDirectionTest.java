package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapDirectionTest {
    MapDirection map = MapDirection.WEST;
    MapDirection map1 = MapDirection.EAST;
    MapDirection map2 = MapDirection.NORTH;
    MapDirection map3 = MapDirection.SOUTH;

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
        assertEquals(map2, map2.next());
    }

    @Test
    void checkIfNextIsOkForMap3() {
        assertEquals(map3, map3.next());
    }

    @Test
    void checkIfPreviousIsOk() {
        assertEquals(map, map.previous());
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
        assertEquals(map3, map3.previous());
    }
}
