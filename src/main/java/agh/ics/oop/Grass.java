package agh.ics.oop;

public class Grass implements IMapElement{
    public Vector2d getLocation() {
        return position;
    }

    private Vector2d position;
    public Grass(Vector2d position){
        this.position=position;
    }

    @Override
    public String toString() {
        return "*";
    }
}
