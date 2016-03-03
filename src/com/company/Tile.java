package com.company;
/*
Created by Mies on 18/02/16.
*/

public class Tile {

    RowOptionsGenerator combi = new RowOptionsGenerator();

    int width;
    int length;
    String name;
    // de constructor om een type:Tile te maken met een bepaalde breedte (width), lengte (length) en naam in het veld.
    // tevens voegt het de breedte van de gemaakte tegel toe aan een array (tileWidths) om daar combi's mee te maken.
    public Tile(int width, int length, String name) {
        this.width = width;
        this.length = length;
        this.name = name;
        combi.tileWidths.add(width);
    }
}





