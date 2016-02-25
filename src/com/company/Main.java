package com.company;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class Main {


    static public ArrayList<ArrayList<String>> ListField = new ArrayList<> ();
    static public String FieldValue;

    public static void main(String[] args) {
        TheField veld = new TheField();
        //TheTiles tegel = new TheTiles();
        //SetTile zetTegel = new SetTile();

        //ListField = new ArrayList<>();

        //veld.ArrayListField();
        //zetTegel.SetTileInListField(tegel.Tile7A,0,0);



        generateRowOptions rowOptions = new generateRowOptions();

        rowOptions.run();

    }

   /* public void printField() {

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
    }*/

    /*Waarom zijn bananen krom?
    Als ze recht zijn vallen ze om
    pom pom pom
    ze liggen krom van het lachen*/
}
