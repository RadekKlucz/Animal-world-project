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

//    public static void loopMethodToControlAnimal(String[] args) {
//        Animal createAnimal = new Animal();
//        var moves = OptionsParser.parse(args);
//
//        out.println(moves);
//        for (var i : moves) {
//            createAnimal.move(i);
//            out.println(createAnimal);
//
//        }
//    }

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
//        Vector2d b = new Vector2d(2, 2);

//      LAB3
//        Animal createAnimal = new Animal();
//        out.println(createAnimal.isAt(b));
//        out.println(createAnimal.toString());
//        createAnimal.move(MoveDirection.RIGHT);
//        out.println(createAnimal);
//        createAnimal.move(MoveDirection.LEFT);
//        out.println(createAnimal);
//        out.println(createAnimal.toString());
//        String[] m = {"f b r l f f r r f f f f f f f f"};
//        loopMethodToControlAnimal(m);

//      LAB4
        var directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
    }
}