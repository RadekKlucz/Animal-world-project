package agh.ics.oop;

import java.util.LinkedHashMap;
public abstract class AbstractWorldMap implements IWorldMap {

    protected final MapVisualizer mapVisualiser = new MapVisualizer(this);
    protected final LinkedHashMap<Vector2d, IMapElement> mapElementsList = new LinkedHashMap<>();
    protected Vector2d lowerLeftCorner = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
    protected Vector2d upperRightCorner = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);

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
        throw new IllegalArgumentException("Cannot place animal on position: " + animal.getPosition());
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return mapElementsList.get(position) != null;
    }

    @Override
    public IMapElement objectAt(Vector2d position) {
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