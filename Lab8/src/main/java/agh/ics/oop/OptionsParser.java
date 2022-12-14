package agh.ics.oop;

import java.util.Objects;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.List;

public class OptionsParser {
    public static List<MoveDirection> parse(String[] listOfChar) {
        return Arrays.stream(listOfChar)
                     .map(OptionsParser::mapDirection)
                     .filter(Objects::nonNull)
                     .collect(Collectors.toList());
    }

    private static MoveDirection mapDirection(String str) {
            return switch (str) {
                case "forward", "f" -> MoveDirection.FORWARD;
                case "backward", "b" -> MoveDirection.BACKWARD;
                case "left", "l" -> MoveDirection.LEFT;
                case "right", "r" -> MoveDirection.RIGHT;
                default -> throw new IllegalArgumentException(str + " is not legal move specification");
            };
        }
    }