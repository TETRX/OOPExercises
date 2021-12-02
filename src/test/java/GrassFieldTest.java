import agh.ics.oop.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest {
    @Test
    public void testPlaceAndObjectAt(){
        GrassField map = new GrassField(10);
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
        GrassField map = new GrassField(10);
        Vector2d initialPosition1 = new Vector2d(1, 2);
        Animal animal1 = new Animal(map, initialPosition1);
        map.place(animal1);
        assertFalse(map.canMoveTo(initialPosition1));
        assertTrue(map.canMoveTo(new Vector2d(2,2)));
    }

    @Test
    public void testGrass(){
        RandomnessSource randomnessSource = new RandomnessSource() {
            @Override
            public int randInt(int l, int r) {
                return 1;
            }
        };
        GrassField map = new GrassField(1,randomnessSource);
        assertNotNull(map.objectAt(new Vector2d(1, 1)));
    }
}
