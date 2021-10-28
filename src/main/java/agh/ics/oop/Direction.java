package agh.ics.oop;

public enum Direction {
    FORWARD("Zwierzak idzie do przodu"),
    LEFT("Zwierzak skręca w lewo"),
    RIGHT("Zwierzak skręca w prawo"),
    BACKWARD("Zwierzak idzie do tyłu");

    public final String msg;

    Direction(String msg){
        this.msg=msg;
    }
}
