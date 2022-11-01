package agh.ics.oop;

import static java.lang.System.out;

public class World {
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

    public static void loopMethodToControlAnimal(String[] args) {
        OptionsParser stringToEnum = new OptionsParser();
        Animal createAnimal = new Animal();
        for (MoveDirection i : stringToEnum.parse(args)) {
            out.println(createAnimal.move(i));
            out.println(stringToEnum.parse(args));
        }
    }

    public static void main(String[] args) {
//      LAB1
//        out.println("System wystartowal: ");
//        checkDirectionAndRunAnimal(args);
//        out.print("System zakonczyl dzialanie.");

//      LAB2
//        Vector2d position1 = new Vector2d(1, 2);
//        out.println(position1);
//        out.println(position1.toString());
//        Vector2d position2 = new Vector2d(-2, 1);
//        out.println(position2);
//        out.println(position1.add(position2));
//        Vector2d a = new Vector2d(2, 5);
//        MapDirection map = MapDirection.NORTH;
//        out.println(map.previous());
//        out.println(map.next());
//        out.println(map.toString());
//        out.println(Arrays.toString(map.toUnitVector()));
        Vector2d b = new Vector2d(2, 2);

//      LAB3
        Animal createAnimal = new Animal();
        out.println(createAnimal.isAt(b));
        out.println(createAnimal.toString());
        out.println(createAnimal.move(MoveDirection.RIGHT));
        out.println(createAnimal.move(MoveDirection.LEFT));
        out.println(createAnimal.toString());
        String[] m = {"forward", "b", "backward", "l", "r", "left"};
        loopMethodToControlAnimal(m);
//      Odpowiedz na pytanie: jak zaimplementować mechanizm, który wyklucza pojawienie się dwóch zwierząt w tym samym miejscu.

//        Stworzyłbym metodę, która sprawdza równość dwóch obiektów (maszych zwierzątek) za pomocą equals.
//        Jeżeli zwierzątka pojawiałyby się na tej samej pozycji (zmienna position), to za pomocą wylosowania
//        randomowego kieunku zmineniłbym pozycję tak, aby na siebie nie nachodziły
    }
}