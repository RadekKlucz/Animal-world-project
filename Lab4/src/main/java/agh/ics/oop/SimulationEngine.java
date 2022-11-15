package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine {
    private final List<MoveDirection> moveDirectionsList;
    private final Vector2d[] listOfVectors2d;
    private final IWorldMap map;

    public SimulationEngine(List<MoveDirection>  moveDirectionsList, IWorldMap map, Vector2d[] listOfVectors2d) {
        this.moveDirectionsList = moveDirectionsList;
        this.listOfVectors2d = listOfVectors2d;
        this.map = map;

        for (Vector2d position : listOfVectors2d) {
            this.map.place(new Animal(this.map, position));
        }
    }

    @Override
    public void run() {
        int number = 0;
        List<Animal> animals = new ArrayList<>();

        for (Animal animal : RectangularMap.animals) {
            if (animal.map.equals(this.map)) {
                animals.add(animal);
            }
        }
        for (MoveDirection direction : moveDirectionsList) {
            if (animals.size() == number) {
                number = 0;
            }
            animals.get(number).move(direction);
            number += 1;
        }
    }
}