package agh.ics.oop;

import agh.ics.oop.Direction;

import java.util.Arrays;
import java.util.Objects;

public class World {
    public static void run(Direction[] directions) {
        Arrays.stream(directions)
                .forEach(direction -> System.out.println(direction.msg));
    }

    private static Direction convertSingle(String arg){
        switch (arg) {
            case "r":
                return Direction.RIGHT;
            case "l":
                return Direction.LEFT;
            case "f":
                return Direction.FORWARD;
            case "b":
                return Direction.BACKWARD;
            default:
                return null;
        }
    }

    private static Direction[] convert(String[] args){
        return Arrays.stream(args)
                .map(World::convertSingle)
                .filter(Objects::nonNull)
                .toArray(Direction[]::new);
    }


    public static void main(String[] args){
        System.out.println("system wystartował");
        Direction[] directions = convert(args);
        run(directions);
        System.out.println("system zakończył działanie");
    }
}
