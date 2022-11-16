package agh.ics.oop;
import java.util.*;


public class OptionsParser {
    public List<MoveDirection> parse(String[] listOfChar) {
        List <MoveDirection> moves = new ArrayList<>();
        for (String i : listOfChar) {
            switch (i) {
                case "f":
                case "forward":
                    moves.add(MoveDirection.FORWARD);
                    break;
                case "b":
                case "backward":
                    moves.add(MoveDirection.BACKWARD);
                    break;
                case "l":
                case "left":
                    moves.add(MoveDirection.LEFT);
                    break;
                case "r":
                case "right":
                    moves.add(MoveDirection.RIGHT);
                    break;
            }
        }
        return moves;
    }
}
