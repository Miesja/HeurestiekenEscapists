package com.company;

Created by Mies on 18/02/16.

public class Tile{
        TheField veld = new TheField
}

public class TheField {

    // de dimensies van het veld.
    public static final int X_WIDTH = 17;
    public static final int Y_LENGTH = 17;

    //2D Array veld
    public veld [][] Field;

    public void ArrayField () {

        Field = new String[X_WIDTH][Y_LENGTH];
    }






    int width;
    int length;
    String name;

    public Tile(int width, int length, String name){
        width = width;
        this.width = width;
        length = length;
        this.length = length;
        name = "";
        this.name = name;
        return width;
        return length;
        return name;

    }

    public void SetTile(, int XPoint, int YPoint) {
        for (int x = XPoint; x < (XPoint + width); x++) {
            for (int y = YPoint; y < YPoint + length; y++) {
                TheField.Field[x][y] = name;
            }
        }
    }


tile7A.setTile(5,6);





