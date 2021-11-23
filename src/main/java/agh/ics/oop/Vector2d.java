package agh.ics.oop;

import java.util.Objects;

public class Vector2d {
    public final int x,y;

    public Vector2d(int x,int y) {
        this.x=x;
        this.y=y;
    }

    public String toString(){
        return "("+x+","+y+")";
    }

    public boolean precedes(Vector2d other){
        return other.x>=x && other.y>=y;
    }

    public boolean follows(Vector2d other){
        return other.precedes(this);
    }

    public Vector2d upperRight(Vector2d other){
        return new Vector2d(Integer.max(x, other.x),Integer.max(y, other.y));
    }

    public Vector2d lowerLeft(Vector2d other){
        return new Vector2d(Integer.min(x,other.x),Integer.min(y,other.y));
    }

    public Vector2d add(Vector2d other){
        return new Vector2d(x+other.x,y+other.y);
    }

    public Vector2d subtract(Vector2d other){
        return new Vector2d(x-other.x,y-other.y);
    }

    public boolean equals(Object other){
        try {
            Vector2d otherV = (Vector2d) other;
            return otherV.x == x && otherV.y == y;
        }catch (ClassCastException e){ //probably bad practice
            return false;
        }
    }

    public Vector2d opposite(){
        return new Vector2d(-x,-y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}