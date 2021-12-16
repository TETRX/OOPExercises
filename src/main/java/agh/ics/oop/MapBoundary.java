package agh.ics.oop;

import java.util.*;

public class MapBoundary implements IPositionChangeObserver{
    private final SortedSet<Vector2d> elementsByX, elementsByY;

    public MapBoundary() {
        elementsByX = new TreeSet<>(((o1, o2) -> {
            if(o1.x==o2.x){
            return o1.y-o2.y;
        } return o1.x- o2.x; }));
        elementsByY = new TreeSet<>(((o1, o2) -> {
            if(o1.y==o2.y){
                return o1.x-o2.x;
            } return o1.y- o2.y; })
        );
    }

    public void addElement(Animal animal){
        Vector2d location = animal.getLocation();
        
        elementsByX.add(location);
        elementsByY.add(location);

        animal.addObserver(this);
    }

    public Vector2d getLowerLeft(){
        Vector2d lowest = elementsByY.first();
        Vector2d leftmost = elementsByX.first();
        return lowest.lowerLeft(leftmost);
    }

    public Vector2d getUpperRight(){
        Vector2d upmost = elementsByY.last();
        Vector2d rightmost = elementsByX.last();
        return upmost.upperRight(rightmost);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        elementsByX.remove(oldPosition);
        elementsByY.remove(oldPosition);

        elementsByX.add(newPosition);
        elementsByY.add(newPosition);
    }

    public static void main(String[] args) {
        Vector2d x= new Vector2d(1,0),y = new Vector2d(0,1),v = new Vector2d(-1, 0),z = new Vector2d(0,-1);
        Animal ax = new Animal(null,x), ay = new Animal(null,y), av = new Animal(null,v), az = new Animal(null,z);
        MapBoundary mapBoundary = new MapBoundary();
        mapBoundary.addElement(ax);
        mapBoundary.addElement(ay);
        mapBoundary.addElement(av);
        mapBoundary.addElement(az);
        System.out.println(mapBoundary.getLowerLeft());
        System.out.println(mapBoundary.getUpperRight());
    }
}
