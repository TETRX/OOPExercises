package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;


public class GrassField extends AbstractWorldMap {
    private int n;
    private Map<Vector2d, IMapElement> nonAnimalObjects;
    private Vector2d lowerLeftGrass, upperRightGrass;

    private RandomnessSource random;

    public GrassField(int n, RandomnessSource random){
        this.n=n;
        this.random = random;
        int upperBound = (int) Math.sqrt(n*10);
        int lowerBound = 0;

        lowerLeftGrass = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        upperRightGrass = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);

        this.nonAnimalObjects = new HashMap<>();
        for(int i = 0; i<n;i++){
            int x = random.randInt(lowerBound, upperBound);
            int y = random.randInt(lowerBound, upperBound);
            Vector2d grassLocation = new Vector2d(x,y);
            nonAnimalObjects.put(grassLocation,new Grass(grassLocation));
            modifyBoundaries(grassLocation);
        }
        mapBoundary = new MapBoundary();
    }

    public GrassField(int n){
        this(n, new PseudorandomRandomnessSource());
    }

    private void modifyBoundaries(Vector2d grass){
        lowerLeftGrass = lowerLeftGrass.lowerLeft(grass);
        upperRightGrass = upperRightGrass.upperRight(grass);
    }

    public boolean place(Animal animal){
        boolean result = super.place(animal);
        if(result) {
            mapBoundary.addElement(animal);
        }
        return result;
    }


    private final MapBoundary mapBoundary;

    @Override
    public boolean canMoveTo(Vector2d position) {
        return animalOccupyingSpace(position)==null;
    }

    @Override
    public Vector2d getLowerLeft() {
        return lowerLeftGrass.lowerLeft(mapBoundary.getLowerLeft());
    }

    @Override
    public Vector2d getUpperRight() {
        return upperRightGrass.upperRight(mapBoundary.getUpperRight());
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position)!=null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        if(animals.containsKey(position)){
            return animals.get(position);
        }
        if (nonAnimalObjects.containsKey(position)){
            return nonAnimalObjects.get(position);
        }
        return null;
    }

}
