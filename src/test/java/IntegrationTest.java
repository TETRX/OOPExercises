import agh.ics.oop.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


public class IntegrationTest {
    @Test
    public void testSimple(){
        MoveDirection[] directions = new MoveDirection[]{MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.LEFT};

        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(1,1), new Vector2d(3,4) };
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        Vector2d[] actualPositions = engine.getAnimals()
                .stream()
                .map(Animal::getLocation)
                .toArray(Vector2d[]::new);
        MapDirection[] actualOrientations = (MapDirection[]) engine.getAnimals()
                .stream()
                .map(Animal::getMapDirection)
                .toArray(MapDirection[]::new);

        Vector2d[] expectedPositions = new Vector2d[]{new Vector2d(1,2), new Vector2d(3,3)};
        MapDirection[] expectedOrientations = new MapDirection[] {MapDirection.EAST, MapDirection.WEST};

        assertArrayEquals(actualPositions,expectedPositions);
        assertArrayEquals(actualOrientations,expectedOrientations);
    }

    @Test
    public void testCollision(){
        MoveDirection[] directions = new MoveDirection[]{MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.FORWARD};

        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(1,1), new Vector2d(2,1) };
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        Vector2d[] actualPositions = engine.getAnimals()
                .stream()
                .map(Animal::getLocation)
                .toArray(Vector2d[]::new);
        MapDirection[] actualOrientations = (MapDirection[]) engine.getAnimals()
                .stream()
                .map(Animal::getMapDirection)
                .toArray(MapDirection[]::new);

        Vector2d[] expectedPositions = positions;
        MapDirection[] expectedOrientations = new MapDirection[] {MapDirection.EAST, MapDirection.WEST};

        assertArrayEquals(actualPositions,expectedPositions);
        assertArrayEquals(actualOrientations,expectedOrientations);
    }

    @Test
    public void testBorderCollision(){
        int northernBarrier = 5;
        int startY = 1;
        IWorldMap map = new RectangularMap(10, northernBarrier);
        Vector2d[] positions = { new Vector2d(1,startY)};
        MoveDirection[] directions = new MoveDirection[northernBarrier-startY+5];
        Arrays.fill(directions, MoveDirection.FORWARD);

        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        Vector2d[] actualPositions = engine.getAnimals()
                .stream()
                .map(Animal::getLocation)
                .toArray(Vector2d[]::new);
        MapDirection[] actualOrientations = (MapDirection[]) engine.getAnimals()
                .stream()
                .map(Animal::getMapDirection)
                .toArray(MapDirection[]::new);

        Vector2d[] expectedPositions = new Vector2d[]{new Vector2d(1,northernBarrier)};
        MapDirection[] expectedOrientations = new MapDirection[] {MapDirection.NORTH};

        assertArrayEquals(actualPositions,expectedPositions);
        assertArrayEquals(actualOrientations,expectedOrientations);
    }

}
