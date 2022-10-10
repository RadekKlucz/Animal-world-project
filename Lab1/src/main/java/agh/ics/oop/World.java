package agh.ics.oop;

import static java.lang.System.out;

public class World {

    final int myNumber = 15; // It means unchangeable and read-only

//  Pierwsza implemmentacja metody run(), punkt 11
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


//  Druga implementacja metody run(), punkt 14
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

//  Trzecia implementacja metody run(), punktu 16
    public static Direction.ListOfMoves checkDirectionAndRunAnimal(String[] args) {
        Direction.ListOfMoves[] allMoves = Direction.ListOfMoves.values();
        for(Direction.ListOfMoves i : allMoves) {
            for (String j : args) {
                if (i.toString().equals(j)) {
                    switch (i) {
                        case f:
                            out.println("Zwierzatko idzie do przodu");
                            break;
                        case b:
                            out.println("Zwierzatko idzie do tyl");
                            break;
                        case r:
                            out.println("Zwierzatko skreca w prawo");
                            break;
                        case l:
                            out.println("Zwierzatko skreca w lewo");
                            break;
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        out.println("System wystartowal: ");
//        String[] test1 = {"prosto", "lewo", "przod", "tyl"};
//        String[] test2 = {"b", "f", "c", "r", "l"};
//        run(test1);
//        runAnimal(test2);
        checkDirectionAndRunAnimal(args);
        out.print("System zakonczyl dzialanie.");
    }
}
