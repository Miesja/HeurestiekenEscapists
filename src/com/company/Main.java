package com.company;

import java.util.ArrayList;

public class Main {

    static public ArrayList<ArrayList<String>> ListField = new ArrayList<> ();
    static public String FieldValue;

    public static void main(String[] args) {

        TheField veld = new TheField();
        TheTiles tegel = new TheTiles();
        SetTile zetTegel = new SetTile();


        ListField = new ArrayList<ArrayList<String>>();

        veld.ArrayListField();
        zetTegel.SetTileInListField(tegel.Tile7A,0,0);



    }
}
