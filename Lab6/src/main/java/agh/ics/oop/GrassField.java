package agh.ics.oop;

import java.util.Map;
import java.util.Random;

public class GrassField extends AbstractWorldMap implements IWorldMap {

    private final int maximumCoordinates;

    public GrassField(int numberOfGrasses) {
        maximumCoordinates = (int) Math.ceil(Math.sqrt(numberOfGrasses * 10));
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
                this.mapElementsList.put(grassPosition, new Grass(grassPosition));
            }
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        Object object = objectAt(position);
        if (object instanceof Grass) {
            mapElementsList.remove(position);
            addPositionOfGrass(1);
        }
        return super.canMoveTo(position);
    }

    @Override
    public String toString() {
        for (Map.Entry<Vector2d, IMapElement> element : mapElementsList.entrySet()) {
            if (element.getValue() instanceof Animal) {
                this.lowerLeftCorner = this.lowerLeftCorner.lowerLeft(element.getKey());
                this.upperRightCorner = this.upperRightCorner.upperRight(element.getKey());
            }
        }
        return super.toString();
    }
}