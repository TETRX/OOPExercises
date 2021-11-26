package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap {
    protected final List<Animal> animals;

    public AbstractWorldMap(){
        animals = new ArrayList<>();
    }

    protected Animal animalOccupyingSpace(Vector2d position){
        for (Animal animal: animals) {
            if(animal.getLocation().equals(position)){
                return animal;
            }
        }
        return null;
    }

    @Override
    public abstract boolean canMoveTo(Vector2d position);

    @Override
    public boolean place(Animal animal) {
        if(canMoveTo(animal.getLocation())){
            animals.add(animal);
            return true;
        }
        return false;
    }

    protected abstract void setUpPrint();

    protected abstract Vector2d getLowerLeft();

    protected abstract Vector2d getUpperRight();

    public String toString(){
        setUpPrint();
        return new MapVisualizer(this).draw(getLowerLeft(), getUpperRight());
    }

    @Override
    public abstract boolean isOccupied(Vector2d position);

    @Override
    public abstract Object objectAt(Vector2d position);
}
