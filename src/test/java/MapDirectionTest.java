import agh.ics.oop.MapDirection;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class MapDirectionTest {
    @Test
    public void testNext(){
        assertEquals(MapDirection.EAST.next(),MapDirection.SOUTH);
        assertEquals(MapDirection.SOUTH.next(),MapDirection.WEST);
        assertEquals(MapDirection.WEST.next(),MapDirection.NORTH);
        assertEquals(MapDirection.NORTH.next(),MapDirection.EAST);
    }

    @Test
    public void testPrevious(){
        assertEquals(MapDirection.WEST.previous(),MapDirection.SOUTH);
        assertEquals(MapDirection.NORTH.previous(),MapDirection.WEST);
        assertEquals(MapDirection.EAST.previous(),MapDirection.NORTH);
        assertEquals(MapDirection.SOUTH.previous(),MapDirection.EAST);
    }
}
