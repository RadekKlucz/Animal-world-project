package agh.ics.oop;

public class RectangularMap extends AbstractWorldMap implements IWorldMap {

    public RectangularMap(int width, int height) {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("Width and height of map cannot be negative");
        }
        lowerLeftCorner = new Vector2d(0, 0);
        upperRightCorner = new Vector2d(width - 1, height - 1);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(lowerLeftCorner) && position.precedes(upperRightCorner) && super.canMoveTo(position);
    }
}