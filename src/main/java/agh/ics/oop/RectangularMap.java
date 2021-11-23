package agh.ics.oop;

import java.util.*;

public class RectangularMap implements IWorldMap{
    private final Vector2d upperRight, lowerLeft;
    private final List<Animal> animals;


    public RectangularMap(int width, int height){
        this.upperRight = new Vector2d(width,height);
        this.lowerLeft = new Vector2d(0,0);
        animals = new ArrayList<>();
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return (!isOccupied(position)) & position.precedes(upperRight) & position.follows(lowerLeft);
    }

    @Override
    public boolean place(Animal animal) {
        Vector2d animalLocation = animal.getLocation();
        if(canMoveTo(animalLocation)){
            animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal: animals) {
            if(animal.getLocation().equals(position)){
                return animal;
            }
        }
        return null;
    }

    public String toString(){
        return new MapVisualizer(this).draw(lowerLeft, upperRight);
    }

    public static void main(String[] args) {
        RectangularMap map = new RectangularMap(4,4);
        Animal animal1 = new Animal(map, new Vector2d(1,2));
        Animal animal2 = new Animal(map);
        map.place(animal1);
        map.place(animal2);
        System.out.println(map);
    }
}
