package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class Animal extends AbstractWordMapElement {
    private final List<IPositionChangeObserver> observerList = new ArrayList<>();
    private MapDirection directionOnMap;
    private final IWorldMap map;

    public Animal(IWorldMap map) {
        this.map = map;
        this.addObserver(this.map);
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.directionOnMap = MapDirection.NORTH;
        this.position = initialPosition;
        this.map = map;
        this.addObserver(this.map);
    }

    public MapDirection getDirection() {
        return this.directionOnMap;
    }

    @Override
    public String toString() {
        return switch (directionOnMap) {
            case NORTH -> "N";
            case SOUTH -> "S";
            case WEST -> "W";
            case EAST -> "E";
        };
    }

    public boolean isAt(Vector2d checkPosition) {
        return position.equals(checkPosition);
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case RIGHT -> this.directionOnMap = this.directionOnMap.next();
            case LEFT -> this.directionOnMap = this.directionOnMap.previous();
            case FORWARD -> { Vector2d higherPosition = this.position.add(this.directionOnMap.toUnitVector());
            if (map.canMoveTo(higherPosition)) {
                Vector2d oldPosition = this.position;
                positionChanged(oldPosition, higherPosition);
                this.position = higherPosition;
                }
            }
            case BACKWARD -> { Vector2d lowerPosition = this.position.subtract(this.directionOnMap.toUnitVector());
                if (map.canMoveTo(lowerPosition)) {
                    Vector2d oldPosition = this.position;
                    positionChanged(oldPosition, lowerPosition);
                    this.position = lowerPosition;
                }
            }
        }
    }
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        for (IPositionChangeObserver observer : this.observerList) {
            observer.positionChanged(oldPosition, newPosition);
        }
    }

    private void addObserver(IPositionChangeObserver observer) {
        this.observerList.add(observer);
    }

    private void removeObserver(IPositionChangeObserver observer) {
        this.observerList.remove(observer);
    }
}

