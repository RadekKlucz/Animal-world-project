package agh.ics.oop;

import java.util.Random;

public class GrassField extends AbstractWorldMap implements IWorldMap {

    private final int numberOfGrasses;
    private final int maximumCoordinates;
    
    public GrassField(int numberOfGrasses) {
        this.numberOfGrasses = numberOfGrasses;
        this.maximumCoordinates = (int) Math.ceil(Math.sqrt(numberOfGrasses * 10));
        addPositionOfGrass(numberOfGrasses);
    }

    private void addPositionOfGrass(int numberOfGrasses) {
        var random = new Random();
        int start = 0;

        while (start < numberOfGrasses) {
            int x = random.nextInt(this.maximumCoordinates);
            int y = random.nextInt(this.maximumCoordinates);

            Vector2d grassPosition = new Vector2d(x, y);
            if (! isOccupied(grassPosition)) {
                start++;
                this.mapElementsList.add(new Grass(grassPosition));
            }
        }
        }

    @Override
    public boolean canMoveTo(Vector2d position) {
        Object object = objectAt(position);
        if (object instanceof Grass) {
            mapElementsList.remove(object);
            addPositionOfGrass(1);
        }
        return super.canMoveTo(position);
    }

    @Override
    public String toString() {
        for (AbstractWordMapElement element : mapElementsList) {
            this.lowerLeftCorner = this.lowerLeftCorner.lowerLeft(element.getPosition());
            this.upperRightCorner = this.upperRightCorner.upperRight(element.getPosition());
        }
        return super.toString();
    }
}