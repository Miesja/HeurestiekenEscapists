package com.company;

import java.util.ArrayList;

/**
 * Created by Mies on 17/02/16.
 */
public class SetTile {

    TheField veld = new TheField();
    TheTiles tegel = new TheTiles();
    SetTile zetTegel = new SetTile();


    // instance variables die de Locatie aanwijzen voor de te zetten tegel.
    public int XPoint;
    public int YPoint;

    // het vullen van de Tile[][] in een 2D Array Field
    private String[][] Field; // in main als het goed is dé instance variable

    public void SetTileinArrayField(Tile, int XPoint, int YPoint) {
        for (int x = XPoint; x < (XPoint + Tile.width); x++) {
            for (int y = YPoint; y < YPoint + Tile.length; y++) {
                Field[x][y] = Tile.name;
            }
        }
        Tile tile  new Tile(3);
        Tile tile2  new Tile(5);
        System.out.println(tile);
        int width = tile.width();
    }


    // het villen van de Tile[][] in een 2D ArrayList ListField
    private String FieldValue;

    public void SetTileInListField(String[][] StringTile, int XPoint, int YPoint) {

        for (int y = YPoint; y < YPoint + StringTile[0].length; y++) {
            ArrayList<String> TileWidth = new ArrayList<String>();

            veld.FieldLength.at(y)

            for (int x = XPoint; x < XPoint + StringTile.length; x++) {
                if(FieldValue.equals("00")){
                    veld.FieldLength.set(x, StringTile[1][1]);
                }
                TileWidth.add(x, FieldValue);
            }

        }
    }
}

