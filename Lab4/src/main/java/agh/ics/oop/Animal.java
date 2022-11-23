package agh.ics.oop;

public class Animal {
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

    public Vector2d getPosition() {
        return position;
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

//    STARE ROWIAZANIE DLA PORÓWNANIA DO NOWEGO
//    public Object move(MoveDirection direction) {
//        if (position.x < 4 && position.y < 4 && position.y > -4 && position.x > -4) {
//            if (Objects.equals(directionOnMap, MapDirection.NORTH)) {
//                return switch (direction) {
//
//                    case FORWARD ->  position = new Vector2d(position.x, position.y + 1);
//                    case BACKWARD -> position = new Vector2d(position.x, position.y - 1);
//                    case RIGHT -> directionOnMap = MapDirection.EAST;
//                    case LEFT -> directionOnMap = MapDirection.WEST;
//                };
//            } else if (Objects.equals(directionOnMap, MapDirection.SOUTH)) {
//                return switch (direction) {
//
//                    case FORWARD -> position = new Vector2d(position.x, position.y - 1);
//                    case BACKWARD -> position = new Vector2d(position.x, position.y + 1);
//                    case RIGHT -> directionOnMap = MapDirection.WEST;
//                    case LEFT -> directionOnMap = MapDirection.EAST;
//                };
//            } else if (Objects.equals(directionOnMap, MapDirection.EAST)) {
//                return switch (direction) {
//
//                    case FORWARD -> position = new Vector2d(position.x + 1, position.y);
//                    case BACKWARD -> position = new Vector2d(position.x - 1, position.y);
//                    case RIGHT -> directionOnMap = MapDirection.SOUTH;
//                    case LEFT -> directionOnMap = MapDirection.NORTH;
//                };
//            } else if (Objects.equals(directionOnMap, MapDirection.WEST)) {
//                return switch (direction) {
//
//                    case FORWARD -> position = new Vector2d(position.x - 1, position.y);
//                    case BACKWARD -> position = new Vector2d(position.x + 1, position.y);
//                    case RIGHT -> directionOnMap = MapDirection.NORTH;
//                    case LEFT -> directionOnMap = MapDirection.SOUTH;
//                };
//            }
//        } else {
//            return "Out of range";
//        }
//        return null;
//    }
}

