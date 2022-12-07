package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class Animal extends AbstractWordMapElement {
    private static final Vector2d DEF_POSITION = new Vector2d(2, 2);
    private final List<IPositionChangeObserver> observerList = new ArrayList<>();
    private MapDirection directionOnMap;
    private Vector2d position;
    private final IWorldMap map;

    public Animal(IWorldMap map) {
//        this.map = map;
        this(map, DEF_POSITION);
        this.addObserver(this.map);
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        if (!map.canMoveTo(initialPosition)) {
            throw new IllegalArgumentException("Poza mapą albo na zajętej pozycji");
        }
        this.directionOnMap = MapDirection.NORTH;
        this.position = initialPosition;
        this.map = map;
        this.map.place(this);
        this.addObserver(this.map);
    }

    public MapDirection getDirection() {
        return directionOnMap;
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
                positionChanged(higherPosition);
                this.position = higherPosition;
                }
            }
            case BACKWARD -> { Vector2d lowerPosition = this.position.subtract(this.directionOnMap.toUnitVector());
                if (map.canMoveTo(lowerPosition)) {
                    positionChanged(lowerPosition);
                    this.position = lowerPosition;
                }
            }
        }
    }
    private void positionChanged(Vector2d newPosition) {
        for (IPositionChangeObserver observer : this.observerList) {
            observer.positionChanged(this.position, newPosition);
        }
    }

    private void addObserver(IPositionChangeObserver observer) {
        this.observerList.add(observer);
    }

    private void removeObserver(IPositionChangeObserver observer) {
        this.observerList.remove(observer);
    }
}

