import agh.ics.oop.Vector2d;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {
    @Test
    public void testToString(){
        Vector2d vector2d = new Vector2d(5,-3);
        assertEquals("(5,-3)",vector2d.toString());
    }

    @Test
    public void testPrecedes(){
        Vector2d v1 = new Vector2d(3,3);
        assertTrue(v1.precedes(v1));
        Vector2d v2 = new Vector2d(2,-3);
        assertTrue(v2.precedes(v1));
        assertFalse(v1.precedes(v2));
        Vector2d v3 = new Vector2d(3,2);
        assertTrue(v3.precedes(v1));
        assertFalse(v1.precedes(v3));
        Vector2d v4 = new Vector2d(4,1);
        assertFalse(v4.precedes(v1));
        assertFalse(v1.precedes(v4));
    }

    @Test
    public void testFollows(){
        Vector2d v1 = new Vector2d(3,3);
        assertTrue(v1.follows(v1));
        Vector2d v2 = new Vector2d(2,-3);
        assertFalse(v2.follows(v1));
        assertTrue(v1.follows(v2));
        Vector2d v3 = new Vector2d(3,2);
        assertFalse(v3.follows(v1));
        assertTrue(v1.follows(v3));
        Vector2d v4 = new Vector2d(4,1);
        assertFalse(v4.follows(v1));
        assertFalse(v1.follows(v4));
    }

    @Test
    public void testUpperRight(){
        Vector2d v1 = new Vector2d(2,3);
        Vector2d v2 = new Vector2d(1,5);
        assertEquals(new Vector2d(2,5),v1.upperRight(v2));
    }

    @Test
    public void testLowerLeft(){
        Vector2d v1 = new Vector2d(2,3);
        Vector2d v2 = new Vector2d(1,5);
        assertEquals(new Vector2d(1,3),v1.lowerLeft(v2));
    }

    @Test
    public void testAdd(){
        Vector2d v1 = new Vector2d(2,3);
        Vector2d v2 = new Vector2d(1,5);
        assertEquals(new Vector2d(3,8),v1.add(v2));
    }

    @Test
    public void testSubtract(){
        Vector2d v1 = new Vector2d(2,3);
        Vector2d v2 = new Vector2d(1,5);
        assertEquals(new Vector2d(1,-2),v1.subtract(v2));
    }

    @Test
    public void testEquals(){
        Vector2d v1 = new Vector2d(2,3);
        Vector2d v2 = new Vector2d(2,3);
        assertEquals(v1,v2);
        Vector2d v3 = new Vector2d(3,2);
        assertNotEquals(v1,v3);
        Object v4 = new Vector2d(2,3);
        assertEquals(v1,v4);
        Object v5 = new Object();
        assertNotEquals(v1,v5);
    }

    @Test
    public void testOpposite(){
        Vector2d v1 = new Vector2d(2,3);
        assertEquals(new Vector2d(-2,-3),v1.opposite());
    }

    @Test
    public void testHashCode(){
        Vector2d v1 = new Vector2d(2,3);
        Vector2d v2 = new Vector2d(2,3);
        Vector2d v3 = new Vector2d(2,4);
        assertEquals(v1.hashCode(),v2.hashCode());
        assertNotEquals(v1.hashCode(),v3.hashCode());
    }
}
