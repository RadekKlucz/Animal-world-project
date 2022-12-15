package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine {
    private final List<MoveDirection> moveDirectionsList;
    private List<Vector2d> listOfVectors2d;
    private final IWorldMap map;
    private final List<Animal> animals;

    public SimulationEngine(List<MoveDirection>  moveDirectionsList, IWorldMap map, List<Vector2d> listOfVectors2d) {
        this.moveDirectionsList = moveDirectionsList;
        this.listOfVectors2d = listOfVectors2d;
        this.map = map;
        this.animals = new ArrayList<>();

        for (Vector2d position : listOfVectors2d) {
            Animal animal = new Animal(this.map, position);
            if (this.map.place(animal)) {
                animals.add(animal);
            }
        }
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public Vector2d getPositionOfAnimal(int numberOfAnimal) {
        return animals.get(numberOfAnimal).getPosition();
    }

    @Override
    public void run() {
        System.out.println(map);
        int animalsSize = animals.size();
        for(int numberOfAnimal = 0; numberOfAnimal < moveDirectionsList.size(); numberOfAnimal++) {
            animals.get(numberOfAnimal % animalsSize).move(moveDirectionsList.get(numberOfAnimal));
            System.out.println(map);
        }
    }
}