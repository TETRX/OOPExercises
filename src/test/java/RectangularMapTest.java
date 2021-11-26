import agh.ics.oop.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {
    @Test
    public void testSimple(){
        RectangularMap map = new RectangularMap(5,5);
        Animal animal = new Animal(map);
        assertTrue(map.place(animal));
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.RIGHT);
        Vector2d expectedPosition = new Vector2d(Animal.DEFAULT_X,Animal.DEFAULT_Y+1);
        assertEquals(map.objectAt(expectedPosition), animal);
        assertTrue(map.isOccupied(expectedPosition));
    }

    @Test
    public void testCanMoveToOccupied(){
        RectangularMap map = new RectangularMap(10,10);
        Vector2d initialPosition1 = new Vector2d(1, 2);
        Animal animal1 = new Animal(map, initialPosition1);
        map.place(animal1);
        assertFalse(map.canMoveTo(initialPosition1));
        assertTrue(map.canMoveTo(new Vector2d(2,2)));
    }

    @Test
    public void testCanMoveToBoundary(){
        RectangularMap map = new RectangularMap(10,10);
        assertFalse(map.canMoveTo(new Vector2d(11,10)));
        assertFalse(map.canMoveTo(new Vector2d(100,100)));
        assertTrue(map.canMoveTo(new Vector2d(10,10)));
        assertFalse(map.canMoveTo(new Vector2d(0,-1)));
        assertFalse(map.canMoveTo(new Vector2d(-499,5)));

    }
}
