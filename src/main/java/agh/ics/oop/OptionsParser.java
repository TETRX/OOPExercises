package agh.ics.oop;

import java.util.Arrays;
import java.util.Objects;

public class OptionsParser {
    private MoveDirection convertSingle(String arg){
        switch (arg) {
            case "r":
            case "right":
                return MoveDirection.RIGHT;
            case "l":
            case "left":
                return MoveDirection.LEFT;
            case "f":
            case "forward":
                return MoveDirection.FORWARD;
            case "b":
            case "backward":
                return MoveDirection.BACKWARD;
            default:
                throw new IllegalArgumentException(arg + " is not legal move specification");
        }
    }

    public MoveDirection[] parse(String[] args){
        return Arrays.stream(args)
                .map(this::convertSingle)
                .filter(Objects::nonNull)
                .toArray(MoveDirection[]::new);
    }
}
