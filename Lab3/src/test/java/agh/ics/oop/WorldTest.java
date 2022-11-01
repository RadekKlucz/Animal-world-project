package agh.ics.oop;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WorldTest {
    // given
    Vector2d positionStart = new Vector2d(2, 2);
    Vector2d position2_3 = new Vector2d(2, 3);
    Vector2d position3_2 = new Vector2d(3, 2);
    Vector2d position2_1 = new Vector2d(2, 1);
    Vector2d position1_2 = new Vector2d(1, 2);
    String expectedToString = "Animal is on: direction = Północ, position = (2, 2)";
    String[] mapInStrings = {"forward", "b", "right", "l", "r", "backward", "f", "left"};

    // when
    Animal animal1 = new Animal();
    Animal animal2 = new Animal();

    // test
    @Test
    void checkRightOrientation() {
        assertEquals(expectedToString, animal1.toString());
    }

    @Test
    void checkWrongOrientation() {
        animal1.setPosition(position2_3);
        animal1.setDirection(MapDirection.SOUTH);
        assertNotEquals(expectedToString, animal1.toString());
    }

    @Test
    void checkPositionsStartNorth() {
        // NORTH
        assertEquals(position2_3, animal1.move(MoveDirection.FORWARD));
        assertEquals(positionStart, animal1.move(MoveDirection.BACKWARD));
        assertEquals(MapDirection.EAST, animal1.move(MoveDirection.RIGHT));
        out.println(animal1.toString());
        // EAST
        assertEquals(position3_2, animal1.move(MoveDirection.FORWARD));
        assertEquals(positionStart, animal1.move(MoveDirection.BACKWARD));
        assertEquals(MapDirection.SOUTH, animal1.move(MoveDirection.RIGHT));
        // SOUTH
        assertEquals(position2_1, animal1.move(MoveDirection.FORWARD));
        assertEquals(positionStart, animal1.move(MoveDirection.BACKWARD));
        assertEquals(MapDirection.WEST, animal1.move(MoveDirection.RIGHT));
        // WEST
        assertEquals(position1_2, animal1.move(MoveDirection.FORWARD));
        assertEquals(positionStart, animal1.move(MoveDirection.BACKWARD));
        assertEquals(MapDirection.NORTH, animal1.move(MoveDirection.RIGHT));
        // NORTH
        assertEquals(MapDirection.WEST, animal1.move(MoveDirection.LEFT));
        // WEST
        assertEquals(MapDirection.SOUTH, animal1.move(MoveDirection.LEFT));
        // SOUTH
        assertEquals(MapDirection.EAST, animal1.move(MoveDirection.LEFT));
        // EAST
        assertEquals(MapDirection.NORTH, animal1.move(MoveDirection.LEFT));
    }

    @Test
    void checkOutOfRange() {
        animal2.move(MoveDirection.FORWARD);
        animal2.move(MoveDirection.FORWARD);
        assertEquals("Out of range", animal2.move(MoveDirection.FORWARD));
    }

    @Test
    void checkInputList() {
        OptionsParser stringToEnumTest = new OptionsParser();
        List <MoveDirection> moves = new ArrayList<>();
        moves.add(MoveDirection.FORWARD);
        moves.add(MoveDirection.BACKWARD);
        moves.add(MoveDirection.RIGHT);
        moves.add(MoveDirection.LEFT);
        moves.add(MoveDirection.RIGHT);
        moves.add(MoveDirection.BACKWARD);
        moves.add(MoveDirection.FORWARD);
        moves.add(MoveDirection.LEFT);
        assertEquals(moves, stringToEnumTest.parse(mapInStrings));
    }
}
