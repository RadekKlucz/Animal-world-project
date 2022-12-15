package agh.ics.oop;

import java.util.TreeMap;

public class MapBoundary implements IPositionChangeObserver {
    private final TreeMap<Vector2d, IMapElement> mapElementX = new TreeMap<Vector2d, IMapElement>(new MapBoundaryComparison("x"));
    private final TreeMap<Vector2d, IMapElement> mapElementY = new TreeMap<Vector2d, IMapElement>(new MapBoundaryComparison("y"));

    public void addElement(IMapElement element) {
        this.mapElementX.put(element.getPosition(), element);
        this.mapElementY.put(element.getPosition(), element);
    }

    public void removeElement(IMapElement element) {
        this.mapElementX.remove(element.getPosition());
        this.mapElementY.remove(element.getPosition());
    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        IMapElement element = this.mapElementX.get(oldPosition);

        this.mapElementX.remove(oldPosition);
        this.mapElementY.remove(oldPosition);
        this.mapElementX.put(newPosition, element);
        this.mapElementY.put(newPosition, element);
    }

    public Vector2d getLowerLeft() {
        if(this.mapElementY.size() == 0) {
            return new Vector2d(0, 0);
        }

        return this.mapElementY.firstKey().lowerLeft(this.mapElementY.firstKey());
    }

    public Vector2d getUpperRight() {
        if(this.mapElementY.size() == 0) {
            return new Vector2d(0, 0);
        }

        return this.mapElementX.lastKey().upperRight(this.mapElementY.lastKey());
    }
}
