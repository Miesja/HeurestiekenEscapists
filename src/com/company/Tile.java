package com.company;

import java.util.ArrayList;

public class Tile {

    int width;
    int length;
    String name;
    boolean turned;
    //de constructor om een type:Tile te maken met een bepaalde breedte (width),
    //lengte (length) en naam in het veld.
    public Tile(int width, int length, String name, boolean turned) {
        this.width = width;
        this.length = length;
        this.name = name;
        this.turned = turned;
    }

    public Tile turnTile(){
        Tile turnedTile = new Tile(this.length, this.width, this.name, turned);
        return turnedTile;
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Tile)){
            return false;
        }

        Tile otherTile = (Tile)obj;
        return width == otherTile.width && length == otherTile.length;

    }

    @Override
    public int hashCode() {
        return width^3+length*8-width*2;
    }
}





