import agh.ics.oop.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;


public class WorldTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testSimple(){
        World.main(new String[]{"f", "r"});
        String expectedOutput = Animal.LOCATION_STRING+new Vector2d(2,3) + Animal.POINTING_STRING + MapDirection.EAST;
        assertEquals(expectedOutput, outputStreamCaptor.toString()
                .trim());
    }

    @Test
    public void testComplicated(){
        World.main(new String[]{"f", "f", "f", "b", "l", "f", "f", "f", "r"});
        String expectedOutput = Animal.LOCATION_STRING+new Vector2d(0,3) + Animal.POINTING_STRING + MapDirection.NORTH;
        assertEquals(expectedOutput, outputStreamCaptor.toString()
                .trim());
    }

    @Test
    public void testWrongInput(){
        World.main(new String[]{"f", "r", "dawfa", "awfag", "sgese", "fowrard"});
        String expectedOutput = Animal.LOCATION_STRING+new Vector2d(2,3) + Animal.POINTING_STRING + MapDirection.EAST;
        assertEquals(expectedOutput, outputStreamCaptor.toString()
                .trim());
    }
}
