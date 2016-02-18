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

    public printField()
    {
        for( int i = 0; i < Y_LENGTH; i++ )
        {
            String Row = new String;
            Row = "";
            for( int j = 0; j < X_WIDTH; j++)
            {
                String A = new String;
                A = StringTile[ i ][ j ]
                Row += A;
            }
            System.out.println( Row );
        }
    }
}
