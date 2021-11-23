import agh.ics.oop.Animal;
import agh.ics.oop.MapDirection;
import agh.ics.oop.MoveDirection;
import agh.ics.oop.Vector2d;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {
//    @Test
//    public void testToStringDefault(){
//        Animal animal = new Animal();
//        assertEquals(animal.toString(), Animal.LOCATION_STRING+new Vector2d(Animal.DEFAULT_X,Animal.DEFAULT_Y) + Animal.POINTING_STRING + Animal.DEFAULT_ORIENTATION);
//    }
//
//    @Test
//    public void testIsAtDefault(){
//        Animal animal = new Animal();
//        Vector2d animalLocation = new Vector2d(Animal.DEFAULT_X, Animal.DEFAULT_Y);
//        Vector2d notAnimalLocation = new Vector2d(Animal.DEFAULT_X+5, Animal.DEFAULT_Y);
//        assertTrue(animal.isAt(animalLocation));
//        assertFalse(animal.isAt(notAnimalLocation));
//    }
//
//    @Test
//    public void testMove(){
//        Animal animal = new Animal();
//        Vector2d animalLocation = new Vector2d(Animal.DEFAULT_X, Animal.DEFAULT_Y);
//        assertTrue(animal.isAt(animalLocation));
//
//        animal.move(MoveDirection.FORWARD);
//        Vector2d newAnimalLocation = new Vector2d(Animal.DEFAULT_X, Animal.DEFAULT_Y+1);
//        assertTrue(animal.isAt(newAnimalLocation));
//    }
//
//    @Test
//    public void testTurnRightMove(){
//
//        Animal animal = new Animal();
//        animal.move(MoveDirection.RIGHT);
//        animal.move(MoveDirection.FORWARD);
//        Vector2d newAnimalLocation = new Vector2d(Animal.DEFAULT_X+1, Animal.DEFAULT_Y);
//        assertTrue(animal.isAt(newAnimalLocation));
//    }
//
//    @Test
//    public void testTurnLeftMove(){
//
//        Animal animal = new Animal();
//        animal.move(MoveDirection.LEFT);
//        animal.move(MoveDirection.FORWARD);
//        Vector2d newAnimalLocation = new Vector2d(Animal.DEFAULT_X-1, Animal.DEFAULT_Y);
//        assertTrue(animal.isAt(newAnimalLocation));
//    }
//
//    @Test
//    public void testMoveUpBoundary() {
//        Animal animal = new Animal();
//        for(int i=Animal.DEFAULT_Y; i<Animal.ENCLOSURE_NORTHERN_BARRIER+5;i++){ // move to the barrier and then some
//            animal.move(MoveDirection.FORWARD);
//        }
//        Vector2d animalLocation = new Vector2d(Animal.DEFAULT_X, Animal.ENCLOSURE_NORTHERN_BARRIER);
//        assertTrue(animal.isAt(animalLocation));
//
//    }
//
//
//    @Test
//    public void testMoveRightBoundary() {
//        Animal animal = new Animal();
//        animal.move(MoveDirection.RIGHT);
//
//        for(int i=Animal.DEFAULT_Y; i<Animal.ENCLOSURE_NORTHERN_BARRIER+5;i++){
//            animal.move(MoveDirection.FORWARD);
//        }
//        Vector2d animalLocation = new Vector2d(Animal.ENCLOSURE_EASTERN_BARRIER, Animal.DEFAULT_Y);
//        assertTrue(animal.isAt(animalLocation));
//
//    }
}
