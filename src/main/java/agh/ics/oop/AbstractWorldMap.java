package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap {
    protected final Map<Vector2d,Animal> animals;

    public AbstractWorldMap(){
        animals = new HashMap<>();
    }

    protected Animal animalOccupyingSpace(Vector2d position){
        return animals.get(position);
    }

    @Override
    public abstract boolean canMoveTo(Vector2d position);

    @Override
    public boolean place(Animal animal) {
        Vector2d animalLocation = animal.getLocation();
        if(canMoveTo(animalLocation)){
            animals.put(animalLocation, animal);
            return true;
        }
        throw new IllegalArgumentException("cannot add animal to " + animal.getLocation().toString());
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal movingAnimal = animals.get(oldPosition);
        animals.remove(oldPosition);
        animals.put(newPosition,movingAnimal);
    }

    public abstract Vector2d getLowerLeft();

    public abstract Vector2d getUpperRight();

    public String toString(){
        return new MapVisualizer(this).draw(getLowerLeft(), getUpperRight());
    }

    @Override
    public abstract boolean isOccupied(Vector2d position);

    @Override
    public abstract Object objectAt(Vector2d position);
}
