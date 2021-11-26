package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;


public class GrassField extends AbstractWorldMap {
    private int n;
    private List<IMapElement> objects;
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

        this.objects = new ArrayList<>();
        for(int i = 0; i<n;i++){
            int x = random.randInt(lowerBound, upperBound);
            int y = random.randInt(lowerBound, upperBound);
            objects.add(new Grass(new Vector2d(x,y)));
        }
        modifyBoundaries();
    }

    public GrassField(int n){
        this(n, new PseudorandomRandomnessSource());
    }

    private void modifyBoundaries(){
        for (IMapElement mapElement: objects) {
            Vector2d location = mapElement.getLocation();
            modifyBoundariesGivenXY(location.x,location.y);
        }
    }

    private void modifyBoundariesGivenXY(int x, int y){
        leftmost = Math.min(x,leftmost);
        rightmost = Math.max(x,rightmost);
        lowest = Math.min(y,lowest);
        highest = Math.max(y,highest);
    }

    public boolean place(Animal animal){
        boolean parentResult = super.place(animal);
        if(parentResult){
            objects.add(animal);
        }
        return parentResult;
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
        for (IMapElement mapElement: objects) {
            if (mapElement.getLocation().equals(position)){
                return mapElement;
            }
        }
        return null;
    }

}
