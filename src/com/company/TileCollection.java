package com.company;


import java.util.ArrayList;

public class TileCollection {
    ArrayList<Tile> tiles = new ArrayList<>();

    //Haalt een specifieke tile uit de collectie en geeft deze terug zodat er verder mee gewerkt kan worden
    public Tile giveTile(int index){
        Tile x = tiles.get(index);
        //remove( tile);
        return x;
    }

    //Haalt een tile uit de collectie zodat deze niet nogmaals gebruikt kan worden in een Grid
    public void remove(Tile tile){
        tiles.remove(tile);
    }
}
