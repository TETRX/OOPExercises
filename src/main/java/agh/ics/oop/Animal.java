package agh.ics.oop;

public class Animal implements IMapElement {
    public MapDirection getMapDirection() {
        return mapDirection;
    }

    private MapDirection mapDirection;
    private Vector2d location;

    public static final int DEFAULT_X=2;
    public static final int DEFAULT_Y=2;
    public static final MapDirection DEFAULT_ORIENTATION= MapDirection.NORTH;

    public static final String LOCATION_STRING = "Located: ";
    public static final String POINTING_STRING = " pointing: ";

    private IWorldMap map;
    public Animal(IWorldMap map){
        this.mapDirection=DEFAULT_ORIENTATION;
        this.location= new Vector2d(Animal.DEFAULT_X,Animal.DEFAULT_Y);
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this(map);
        this.location = initialPosition;
    }

    public String toString(){

        return this.mapDirection.shortString();
    }

    public boolean isAt(Vector2d position){
        return location.equals(position);
    }

    public Vector2d getLocation(){ return location;}

    public void move(MoveDirection direction){
        Vector2d newLocation=null;
        switch (direction){
            case LEFT:
                this.mapDirection=this.mapDirection.previous();
                break;
            case RIGHT:
                this.mapDirection=this.mapDirection.next();
                break;
            case FORWARD:
                newLocation = this.location.add(this.mapDirection.toUnitVector());
                break;
            case BACKWARD:
                newLocation = this.location.subtract(this.mapDirection.toUnitVector());
                break;
        }
        if (newLocation!=null){
            if(map.canMoveTo(newLocation)) {
                this.location = newLocation;
            }
        }
    }
}
