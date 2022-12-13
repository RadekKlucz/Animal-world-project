package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Application;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class World {

    public static void run(String[] moves) {
        for (int i = 0; i < moves.length; i++) {
            if (i == 0) {
                out.print(moves[i] + ',');
            } else if (i > 0 && i < moves.length - 1) {
                out.print(' ' + moves[i] + ",");
            } else {
                out.println(' ' + moves[i]);
            }
        }
    }

    public static void runAnimal(String[] moves) {
        for (String i : moves) {
            switch (i) {
                case "f":
                    out.println("Zwierzatko idzie do przodu");
                    break;
                case "b":
                    out.println("Zwierzatko idzie do tyl");
                    break;
                case "r":
                    out.println("Zwierzatko skreca w prawo");
                    break;
                case "l":
                    out.println("Zwierzatko skreca w lewo");
                    break;
            }
        }
    }

    public static void checkDirectionAndRunAnimal(String[] args) {
        MoveDirection[] allMoves = MoveDirection.values();
        for(MoveDirection i : allMoves) {
            for (String j : args) {
                if (i.toString().equals(j)) {
                    switch (i) {
                        case FORWARD -> out.println("Zwierzatko idzie do przodu");
                        case BACKWARD -> out.println("Zwierzatko idzie do tyl");
                        case RIGHT -> out.println("Zwierzatko skreca w prawo");
                        case LEFT -> out.println("Zwierzatko skreca w lewo");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            Application.launch(App.class, String.valueOf(args));
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
        }
    }
}