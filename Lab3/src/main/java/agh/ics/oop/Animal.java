package agh.ics.oop;

import java.util.Objects;

public class Animal {
    private MapDirection directionOnMap = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2, 2);

    public void setDirection(MapDirection directionOnMap) {
        this.directionOnMap = directionOnMap;
    }

    public void setPosition(Vector2d position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Animal is on: " +
                "direction = " + directionOnMap +
                ", position = " + position;
    }

    public boolean isAt(Vector2d checkPosition) {
        return position.equals(checkPosition);
    }

    public Object move(MoveDirection direction) {
        if (position.x < 4 && position.y < 4 && position.y > -4 && position.x > -4) {
            if (Objects.equals(directionOnMap, MapDirection.NORTH)) {
                return switch (direction) {

                    case FORWARD ->  position = new Vector2d(position.x, position.y + 1);
                    case BACKWARD -> position = new Vector2d(position.x, position.y - 1);
                    case RIGHT -> directionOnMap = MapDirection.EAST;
                    case LEFT -> directionOnMap = MapDirection.WEST;
                };
            } else if (Objects.equals(directionOnMap, MapDirection.SOUTH)) {
                return switch (direction) {

                    case FORWARD -> position = new Vector2d(position.x, position.y - 1);
                    case BACKWARD -> position = new Vector2d(position.x, position.y + 1);
                    case RIGHT -> directionOnMap = MapDirection.WEST;
                    case LEFT -> directionOnMap = MapDirection.EAST;
                };
            } else if (Objects.equals(directionOnMap, MapDirection.EAST)) {
                return switch (direction) {

                    case FORWARD -> position = new Vector2d(position.x + 1, position.y);
                    case BACKWARD -> position = new Vector2d(position.x - 1, position.y);
                    case RIGHT -> directionOnMap = MapDirection.SOUTH;
                    case LEFT -> directionOnMap = MapDirection.NORTH;
                };
            } else if (Objects.equals(directionOnMap, MapDirection.WEST)) {
                return switch (direction) {

                    case FORWARD -> position = new Vector2d(position.x - 1, position.y);
                    case BACKWARD -> position = new Vector2d(position.x + 1, position.y);
                    case RIGHT -> directionOnMap = MapDirection.NORTH;
                    case LEFT -> directionOnMap = MapDirection.SOUTH;
                };
            }
        } else {
            return "Out of range";
        }
        return null;
    }
}

