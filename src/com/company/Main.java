package com.company;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class Main {
    TheField veld = new TheField();
    TheTiles tegel = new TheTiles();
    SetTile zetTegel = new SetTile();

    static public ArrayList<ArrayList<String>> ListField = new ArrayList<> ();
    static public String FieldValue;

    public void main(String[] args) {


        ListField = new ArrayList<ArrayList<String>>();

        veld.ArrayListField();
        zetTegel.SetTileInListField(tegel.Tile7A,0,0);



    }

    public void printField() {

        for( int i = 0; i < 17; i++ )
        {
            String Row = "";
            for( int j = 0; j < 17; j++)
            {
                String A = veld.Field[ i ][ j ];
                Row += A;
            }
            System.out.println( Row );
        }
    }
}
