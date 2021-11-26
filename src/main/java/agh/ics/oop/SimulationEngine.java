package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine{
    private MoveDirection[] moves;
    private IWorldMap map;

    public List<Animal> getAnimals() {
        return animals;
    }

    private List<Animal> animals;
    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] animalPositions){
        this.map = map;
        this.moves = moves;

        this.animals = new ArrayList<>();
        for(Vector2d animalPosition : animalPositions){
            Animal animal = new Animal(map,animalPosition);
            if(map.place(animal)){
                animals.add(animal);
            }
        }
    }

    @Override
    public void run() {
        System.out.println(this.map);
        for(int i = 0; i< moves.length;i++){
            System.out.println("Moving animal on "+ animals.get(i%animals.toArray().length).getLocation()+" "+moves[i]);
            animals.get(i%animals.toArray().length).move(moves[i]);
            System.out.println(this.map);
        }
    }


}
