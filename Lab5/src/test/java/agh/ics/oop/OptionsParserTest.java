package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

public class OptionsParserTest {

    @Test
    void testLeft() {
        // given
        var strings = new String[] {"l", "left"};
        var expectedList = List.of(
                MoveDirection.LEFT,
                MoveDirection.LEFT);
        // when
        var actualList = OptionsParser.parse(strings);
        // test
        assertEquals(expectedList, actualList);
    }

    @Test
    void testRight() {
        // given
        var strings = new String[] {"right", "r"};
        var expectedList = List.of(
                MoveDirection.RIGHT,
                MoveDirection.RIGHT);
        // when
        var actualList = OptionsParser.parse(strings);
        // test
        assertEquals(expectedList, actualList);
    }

    @Test
    void testForward() {
        // given
        var strings = new String[] {"f", "forward"};
        var expectedList = List.of(
                MoveDirection.FORWARD,
                MoveDirection.FORWARD);
        // when
        var actaualList = OptionsParser.parse(strings);
        // test
        assertEquals(expectedList, actaualList);
    }

    @Test
    void testBackward() {
        // given
        var strings = new String[] {"backward", "b"};
        var expectedList = List.of(
                MoveDirection.BACKWARD,
                MoveDirection.BACKWARD);
        // when
        var actualList = OptionsParser.parse(strings);
        // test
        assertEquals(expectedList, actualList);
    }

    @Test
    void testWithRandomStrings() {
        // given
        var strings = new String[] {"l", "forward", "right", "abc", "cba", "l", "left", "ddd", "forward", "r"};
        var expectedList = List.of(
                MoveDirection.LEFT,
                MoveDirection.FORWARD,
                MoveDirection.RIGHT,
                MoveDirection.LEFT,
                MoveDirection.LEFT,
                MoveDirection.FORWARD,
                MoveDirection.RIGHT);
        // when
        var actualList = OptionsParser.parse(strings);
        // test
        assertEquals(expectedList, actualList);
    }

}
