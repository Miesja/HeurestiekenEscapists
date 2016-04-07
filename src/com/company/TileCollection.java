package com.company;


import java.util.ArrayList;

public class TileCollection {
    ArrayList<Tile> tiles = new ArrayList<>();

    //Haalt een specifieke tile uit de collectie en geeft deze terug zodat er verder mee gewerkt kan worden
    public Tile giveTile(int index){
        Tile x = tiles.get(index);
        return x;
    }

    //Haalt een tile uit de collectie zodat deze niet nogmaals gebruikt kan worden in een Grid
    public void removeTile(Tile tile){
        tiles.remove(tile);
    }

    //deze functie draait een tegel op zijn zij, dit gebeurd door lengte en breedte om te draaien
    public Tile rotateTile(int index){
        int x;
        Tile tile = tiles.get(index);
        x = tile.width;
        tile.width = tile.length;
        tile.length = x;
        return tile;
    }
}
