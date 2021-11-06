package agh.ics.oop;

public class Animal {
    private MapDirection mapDirection;
    private Vector2d location;

    public static final int DEFAULT_X=2;
    public static final int DEFAULT_Y=2;
    public static final MapDirection DEFAULT_ORIENTATION= MapDirection.NORTH;

    public static final String LOCATION_STRING = "Located: ";
    public static final String POINTING_STRING = " pointing: ";

    public Animal(){
        this.mapDirection=DEFAULT_ORIENTATION;
        this.location= new Vector2d(Animal.DEFAULT_X,Animal.DEFAULT_Y);
    }

    public String toString(){
        return LOCATION_STRING+ this.location.toString() + POINTING_STRING + mapDirection;
    }

    public boolean isAt(Vector2d position){
        return location.equals(position);
    }

    // These define the square which animals cant leave
    public static final int ENCLOSURE_SOUTHERN_BARRIER=0;
    public static final int ENCLOSURE_WESTERN_BARRIER=0;
    public static final int ENCLOSURE_EASTERN_BARRIER=4;
    public static final int ENCLOSURE_NORTHERN_BARRIER=4;
    public static final Vector2d ENCLOSURE_LOWER_LEFT = new Vector2d(ENCLOSURE_WESTERN_BARRIER,ENCLOSURE_SOUTHERN_BARRIER);
    public static final Vector2d ENCLOSURE_UPPER_RIGHT = new Vector2d(ENCLOSURE_EASTERN_BARRIER,ENCLOSURE_NORTHERN_BARRIER);

    public void move(MoveDirection direction){
        switch (direction){
            case LEFT:
                this.mapDirection=this.mapDirection.previous();
                break;
            case RIGHT:
                this.mapDirection=this.mapDirection.next();
                break;
            case FORWARD:
                this.location = this.location.add(this.mapDirection.toUnitVector());
                break;
            case BACKWARD:
                this.location = this.location.subtract(this.mapDirection.toUnitVector());
                break;
        }
        // a move beyond the boundaries should have no effect.
        this.location=this.location.lowerLeft(ENCLOSURE_UPPER_RIGHT);
        this.location=this.location.upperRight(ENCLOSURE_LOWER_LEFT);
    }
}
