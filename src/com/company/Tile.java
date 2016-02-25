package com.company;
/*
Created by Mies on 18/02/16.
*/

public class Tile {

    Grid veld = new Grid;
    RowOptionsGenerator combi = RowOptionsGenerator;

    int width;
    int length;
    String name;

    public Tile(int width, int length, String name) {
        this.width = width;
        this.length = length;
        this.name = name;
        combi.tileWidths.add(width);
    }
}





