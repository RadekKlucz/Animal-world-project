package agh.ics.oop;

import java.util.Objects;
import java.util.Optional;
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
                default -> null;
            };
        }
    }

//public class OptionsParser {
//    public static MoveDirection[] parse(String[] input) {
//        Stream.of(input)
//                .map(instruction -> converToMoveDirection(intruction)).filter(MoveDirection -> MoveDirection != null).toArray(MoveDirection[]::new);// instruction to taka funkcja lambda
//    }
//
//    private static Function<String, MoveDirection> converToMoveDirection(intruction) {
//        return instruction -> switch (instruction) {
//            case "f", "forward" -> MoveDirection.FORWARD;
//            case "b", "backward" -> MoveDirection.BACKWARD;
//            case "r", "right" -> MoveDirection.RIGHT;
//            case "l", "left" -> MoveDirection.LEFT;
//            default -> null;
//        };
//    }
//}