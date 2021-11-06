package agh.ics.oop;

import java.util.Arrays;
import java.util.Objects;

public class World {
    public static void main(String[] args){
        Animal animal = new Animal();
        OptionsParser optionsParser = new OptionsParser();
        for(MoveDirection moveDirection : optionsParser.convert(args)){
            animal.move(moveDirection);
        }
        System.out.println(animal);
    }
}
