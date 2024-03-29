package agh.ics.oop;

import java.util.Map;
import java.util.Random;

public class GrassField extends AbstractWorldMap implements IWorldMap {

    private final int maximumCoordinates;
    private final MapBoundary mapBoundary;

    public GrassField(int numberOfGrasses) {
        this.maximumCoordinates = (int) Math.ceil(Math.sqrt(numberOfGrasses * 10));
        this.mapBoundary = new MapBoundary();
        addPositionOfGrass(numberOfGrasses);
    }

    public void addPositionOfGrass(int numberOfGrasses) {
        var random = new Random();
        int start = 0;

        while (start < numberOfGrasses) {
            int x = random.nextInt(this.maximumCoordinates);
            int y = random.nextInt(this.maximumCoordinates);

            Vector2d grassPosition = new Vector2d(x, y);
            if (!isOccupied(grassPosition)) {
                start++;
                Grass grass = new Grass(grassPosition);
                this.mapBoundary.addElement(grass);
                this.mapElementsList.put(grassPosition, grass);
            }
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        IMapElement element = objectAt(position);
        if (element instanceof Grass) {
            this.mapBoundary.removeElement(element);
            this.mapElementsList.remove(position);
            addPositionOfGrass(1);
        }
        return super.canMoveTo(position);
    }

    @Override
    public String toString() {
        this.lowerLeftCorner = this.mapBoundary.getLowerLeft();
        this.upperRightCorner = this.mapBoundary.getUpperRight();
        return super.toString();
    }

    @Override
    public boolean place(Animal animal) {
        super.place(animal);
        this.mapBoundary.addElement(animal);
        return true;
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        IMapElement element = this.mapElementsList.get(oldPosition);
        this.mapElementsList.put(newPosition, element);
        this.mapBoundary.positionChanged(oldPosition, newPosition);
        this.mapElementsList.remove(oldPosition);
    }
}