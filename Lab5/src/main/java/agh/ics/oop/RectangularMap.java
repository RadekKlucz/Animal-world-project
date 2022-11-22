package agh.ics.oop;

public class RectangularMap extends AbstractWorldMap implements IWorldMap {
    private final int width;
    private final int height;
    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
        lowerLeftCorner = new Vector2d(0, 0);
        upperRightCorner = new Vector2d(width - 1, height - 1);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(lowerLeftCorner) && position.precedes(upperRightCorner) && super.canMoveTo(position);
    }
}