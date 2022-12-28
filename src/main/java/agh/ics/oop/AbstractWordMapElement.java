package agh.ics.oop;

public abstract class AbstractWordMapElement implements IMapElement {

    protected Vector2d position = new Vector2d(2, 2);

    @Override
    public Vector2d getPosition() {
        return this.position;
    }
}