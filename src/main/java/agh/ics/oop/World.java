package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Application;

import java.util.Arrays;
import java.util.Objects;

public class World {
    public static String[] getArgs() {
        return args;
    }

    private static String[] args;

    public static void main(String[] args){
        try {
            World.args=args;
            Application.launch(App.class, args);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
