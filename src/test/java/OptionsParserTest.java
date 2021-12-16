import agh.ics.oop.MoveDirection;
import agh.ics.oop.OptionsParser;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OptionsParserTest {
    @Test
    public void testSimple(){
        String[] testInputs = new String[]{"r", "f", "r", "l", "left", "forward", "b", "backward", "right"};
        MoveDirection[] expectedOutput = new MoveDirection[]{
                MoveDirection.RIGHT,
                MoveDirection.FORWARD,
                MoveDirection.RIGHT,
                MoveDirection.LEFT,
                MoveDirection.LEFT,
                MoveDirection.FORWARD,
                MoveDirection.BACKWARD,
                MoveDirection.BACKWARD,
                MoveDirection.RIGHT
        };

        OptionsParser optionsParser = new OptionsParser();
        assertArrayEquals(expectedOutput, optionsParser.parse(testInputs));
    }

    @Test
    public void testIncorrectInput(){
        String[] testInputs = new String[]{"fowrard"};

        OptionsParser optionsParser = new OptionsParser();
        assertThrows(IllegalArgumentException.class, () -> {optionsParser.parse(testInputs);});
    }
}
