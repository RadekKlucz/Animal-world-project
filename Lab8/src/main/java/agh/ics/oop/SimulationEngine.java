package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class SimulationEngine implements IEngine {
    private List<MoveDirection> moveDirectionsList;
    private final IWorldMap map;
    private final List<Animal> animals;
    private final List<IMapUpdateObserver> observers;
    private int moveDelay = 0;

    public SimulationEngine(IWorldMap map, List<Vector2d> listOfVectors2d) {
        this.map = map;
        this.animals = new ArrayList<>();
        this.observers = new ArrayList<>();

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
        out.println(map);
        int animalsSize = animals.size();
        for(int numberOfAnimal = 0; numberOfAnimal < moveDirectionsList.size(); numberOfAnimal++) {
            animals.get(numberOfAnimal % animalsSize).move(moveDirectionsList.get(numberOfAnimal));
            out.println(map);
            for(IMapUpdateObserver observer : this.observers) {
                observer.positionChanged();
            }

            try {
                Thread.sleep(moveDelay);
            } catch(InterruptedException error) {
                out.println("Something goes wrong: " + error);
            }
        }
    }

    @Override
    public void addObserver(IMapUpdateObserver observer) {
        observers.add(observer);
    }

    @Override
    public void setMoveDelay(int moveDelay) {
        this.moveDelay = moveDelay;
    }

    @Override
    public void setDirections(List<MoveDirection> directions) {
        moveDirectionsList = directions;
    }
}