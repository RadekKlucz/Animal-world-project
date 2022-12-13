package agh.ics.oop;

import java.util.LinkedHashMap;
public abstract class AbstractWorldMap implements IWorldMap {

    protected final MapVisualizer mapVisualiser;
    protected final LinkedHashMap<Vector2d, IMapElement> mapElementsList;
    protected Vector2d lowerLeftCorner;
    protected Vector2d upperRightCorner;

    public AbstractWorldMap() {
        this.mapVisualiser = new MapVisualizer(this);
        this.mapElementsList = new LinkedHashMap<>();
        this.lowerLeftCorner = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        this.upperRightCorner = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(objectAt(position) instanceof Animal);
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            this.mapElementsList.put(animal.getPosition(), animal);
            return true;
        }
//        throw new IllegalArgumentException("Cannot place animal on position: " + animal.getPosition());
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return mapElementsList.get(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return mapElementsList.get(position);
    }

    @Override
    public String toString() {
        return mapVisualiser.draw(lowerLeftCorner, upperRightCorner);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        IMapElement animal = mapElementsList.remove(oldPosition);
        mapElementsList.put(newPosition, animal);
    }

    @Override
    public Vector2d[] getCorners() {
        return new Vector2d[]{this.lowerLeftCorner, this.upperRightCorner};
    }
}