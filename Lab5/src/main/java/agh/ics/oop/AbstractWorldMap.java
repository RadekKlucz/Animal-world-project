package agh.ics.oop;

import java.util.*;
public abstract class AbstractWorldMap implements IWorldMap {

    private final  MapVisualizer mapVisualiser;
    protected final List<AbstractWordMapElement> mapElementsList;
    protected Vector2d lowerLeftCorner = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
    protected Vector2d upperRightCorner = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);

    public AbstractWorldMap() {
        this.mapElementsList = new ArrayList<>();
        this.mapVisualiser = new MapVisualizer(this);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return (!(objectAt(position) instanceof Animal));
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            this.mapElementsList.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for(AbstractWordMapElement element : mapElementsList) {
            if(element.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(AbstractWordMapElement element : mapElementsList) {
            if(element.getPosition().equals(position)) {
                return element;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return mapVisualiser.draw(lowerLeftCorner, upperRightCorner);
    }
}