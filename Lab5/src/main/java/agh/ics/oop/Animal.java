package agh.ics.oop;

public class Animal extends AbstractWordMapElement implements IMapElement {
    private static final Vector2d DEF_POSITION = new Vector2d(2, 2);
    private MapDirection directionOnMap;
    private Vector2d position;
    public IWorldMap map;

    public Animal(IWorldMap map) {
        this(map, DEF_POSITION);
    }
    public Animal(IWorldMap map, Vector2d initialPosition) {
        if (!map.canMoveTo(initialPosition)) {
            throw new IllegalArgumentException("Poza mapą albo na zajętej pozycji");
        }
        this.directionOnMap = MapDirection.NORTH;
        this.position = initialPosition;
        this.map = map;
        this.map.place(this);
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
            case FORWARD -> this.position = checkCorrectMove(this.directionOnMap.toUnitVector());
            case BACKWARD -> this.position = checkCorrectMove(this.directionOnMap.toUnitVector().opposite());
        }
    }

    private Vector2d checkCorrectMove(Vector2d move) {
        var result = this.position.add(move);
        if (map.canMoveTo(result)) {
            return result;
        } else {
            return this.position;
        }
    }
}

