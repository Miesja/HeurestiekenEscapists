package com.company;

import java.util.ArrayList;

/**
 * Created by Mies on 17/02/16.
 */
public class SetTile {

    // instance variables
    public int XPoint;
    public int YPoint;

    // het vullen van de Tile[][] in een 2D Array Field
    private String[][] Field; // in main als het goed is dé instance variable

    public void SetTileinArrayField(String[][] StringTile, int XPoint, int YPoint) {
        for (int x = XPoint; x < (XPoint + StringTile.length); x++) {
            for (int y = YPoint; y < YPoint + StringTile[0].length; y++) {
                Field[x][y] = StringTile[1][1];
            }
        }
    }


    // het villen van de Tile[][] in een 2D ArrayList ListField
    private ArrayList<ArrayList<String>> ListField = new ArrayList<ArrayList<String>>();
    private String FieldValue;

    public void SetTileInListField(String[][] StringTile, int XPoint, int YPoint) {
        for (int y = YPoint; y < YPoint + StringTile[0].length; y++) {
            ArrayList<String> TileWidth = new ArrayList<String>();
            ListField.add(y, TileWidth);

            for (int x = XPoint; x < XPoint + StringTile.length; x++) {
                FieldValue = StringTile[1][1];
                TileWidth.add(x, FieldValue);
            }

        }
    }
}

