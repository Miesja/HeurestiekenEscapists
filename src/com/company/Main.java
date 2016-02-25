package com.company;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class Main {


    static public ArrayList<ArrayList<String>> ListField = new ArrayList<> ();
    static public String FieldValue;
    Grid veld = new Grid

    public static void main(String[] args) {
        //TheTiles tegel = new TheTiles();
        //SetTile zetTegel = new SetTile();

        //ListField = new ArrayList<>();

        //veld.ArrayListField();
        //zetTegel.SetTileInListField(tegel.Tile7A,0,0);



        RowOptionsGenerator rowOptions = new RowOptionsGenerator();
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



    private void makeTiles() {

        Tile tileA = new Tile(7,7,"a");
        Tile tileB = new Tile(7,7,"b");
        Tile tileC = new Tile(7,7,"c");
        Tile tileD = new Tile(5,5,"d");
        Tile tileE = new Tile(5,5,"e");
        Tile tileF = new Tile(5,5,"f");
        Tile tileG = new Tile(3,3,"g");
        Tile tileH = new Tile(3,3,"h");
        Tile tileI = new Tile(3,3,"i");
        Tile tileJ = new Tile(3,3,"j");
        Tile tileK = new Tile(3,3,"k");
        Tile tileL = new Tile(2,2,"l");
    }







}
