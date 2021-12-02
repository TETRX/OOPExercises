package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;


public class GrassField extends AbstractWorldMap {
    private int n;
    private Map<Vector2d, IMapElement> nonAnimalObjects;
    private int lowest, highest, leftmost,rightmost;

    private RandomnessSource random;

    public GrassField(int n, RandomnessSource random){
        this.n=n;
        this.random = random;
        int upperBound = (int) Math.sqrt(n*10);
        int lowerBound = 0;

        lowest = Integer.MAX_VALUE;
        leftmost = Integer.MAX_VALUE;
        highest = Integer.MIN_VALUE;
        rightmost = Integer.MIN_VALUE;

        this.nonAnimalObjects = new HashMap<>();
        for(int i = 0; i<n;i++){
            int x = random.randInt(lowerBound, upperBound);
            int y = random.randInt(lowerBound, upperBound);
            Vector2d grassLocation = new Vector2d(x,y);
            nonAnimalObjects.put(grassLocation,new Grass(grassLocation));
        }
        modifyBoundaries();
    }

    public GrassField(int n){
        this(n, new PseudorandomRandomnessSource());
    }

    private void modifyBoundaries(){
        for (Vector2d location: nonAnimalObjects.keySet()) {
            modifyBoundariesGivenXY(location.x,location.y);
        }
    }

    private void modifyBoundariesGivenXY(int x, int y){
        leftmost = Math.min(x,leftmost);
        rightmost = Math.max(x,rightmost);
        lowest = Math.min(y,lowest);
        highest = Math.max(y,highest);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return animalOccupyingSpace(position)==null;
    }

    @Override
    protected void setUpPrint() {
        modifyBoundaries();
    }

    @Override
    protected Vector2d getLowerLeft() {
        return new Vector2d(leftmost,lowest);
    }

    @Override
    protected Vector2d getUpperRight() {
        return new Vector2d(rightmost,highest);
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
