package com.company;
/*
Created by Mies on 18/02/16.
*/

public class Tile {

    Grid veld = new Grid;

    int width;
    int length;
    String name;

    public Tile(int width, int length, String name) {
        this.width = width;
        this.length = length;
        this.name = name;
    }

    public void SetTile(int XPoint, int YPoint) {
        for (int x = XPoint; x < (XPoint + width); x++) {
            for (int y = YPoint; y < YPoint + length; y++) {
                veld.field[x][y] = name;
            }
        }
    }

}





