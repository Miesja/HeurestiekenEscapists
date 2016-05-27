package com.company;

import java.util.ArrayList;

public class Tile {

    int width;
    int length;
    String name;
    boolean turned;

    //constructor to make a tile.
    public Tile(int width, int length, String name, boolean turned) {
        this.width = width;
        this.length = length;
        this.name = name;
        this.turned = turned;
    }

    // method that "turns" a Tile (changes the boolean turned)
    public Tile turnTile(){
        Tile turnedTile = new Tile(this.length, this.width, this.name, turned);
        return turnedTile;
    }

    // the redefinition of 'equals' as it applies to Tiles
    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Tile)){
            return false;
        }

        Tile otherTile = (Tile)obj;
        return width == otherTile.width && length == otherTile.length;

    }

    // the hashCode used to store the options in a hashset.
    @Override
    public int hashCode() {
        return width^3+length*8-width*2;
    }
}





