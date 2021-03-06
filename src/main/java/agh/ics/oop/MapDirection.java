package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum MapDirection {
    NORTH("NORTH", new Vector2d(0,1)),SOUTH("SOUTH", new Vector2d(0,-1)),WEST("WEST",new Vector2d(-1,0)),EAST("EAST",new Vector2d(1,0));

    private static final MapDirection[] clockwiseOrder = new MapDirection[] {NORTH, EAST,SOUTH, WEST};
    private static final Map<MapDirection, Integer> clockwiseOrderInv= new HashMap<>();
    static {
        for(int i = 0 ; i<clockwiseOrder.length;i++){
            clockwiseOrderInv.put(clockwiseOrder[i],i );
        }
    }



    private final String directionName;
    private final Vector2d unitVectorConversion;

    MapDirection(String directionName, Vector2d unitVector){
        this.directionName=directionName;
        this.unitVectorConversion=unitVector;
    }

    public String toString(){
        return directionName;
    }

    public String shortString(){
        return String.valueOf(directionName.charAt(0));
    }

    public MapDirection next(){
        return clockwiseOrder[(clockwiseOrderInv.get(this)+1)%clockwiseOrder.length];
    }

    public MapDirection previous(){
        return clockwiseOrder[(clockwiseOrderInv.get(this)+clockwiseOrder.length-1)%clockwiseOrder.length];
    }

    public Vector2d toUnitVector(){
        return unitVectorConversion;
    }

}
