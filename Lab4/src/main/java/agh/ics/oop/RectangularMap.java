package agh.ics.oop;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class RectangularMap implements IWorldMap {

    private final Vector2d left;
    private final Vector2d right;
    private final Animal[][] map;
    private final MapVisualizer mapVisualizer;
    public static List<Animal> animals;

    public RectangularMap(int width, int height) {
        left = new Vector2d(0, 0);
        right = new Vector2d(width - 1, height - 1);
        map = new Animal[width][height];
        mapVisualizer = new MapVisualizer(this);
        animals = new LinkedList<>();
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(left) && position.precedes(right) && !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if (!canMoveTo(animal.getPosition())) {
            return false;
        }
        map[animal.getPosition().x][animal.getPosition().y] = animal;
        animals.add(animal);
        return true;
        }

    @Override
    public boolean isOccupied(Vector2d position) {
        return get(position) != null;
    }

    @Override
    public Optional<Object> objectAt(Vector2d position) {
        return Optional.ofNullable(get(position));
    }

    @Override
    public String toString() {
        return mapVisualizer.draw(left, right);
    }

    private Animal get(Vector2d position) {
        if (!(position.follows(left) && position.precedes(right))) {
            return null;
        }
        return map[position.x][position.y];
    }
}
