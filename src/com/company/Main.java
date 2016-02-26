package com.company;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class Main {


    static public ArrayList<ArrayList<String>> ListField = new ArrayList<> ();
    static public String FieldValue;

    public static void main(String[] args) {
        //TheTiles tegel = new TheTiles();
        //SetTile zetTegel = new SetTile();

        //ListField = new ArrayList<>();

        //veld.ArrayListField();
        //zetTegel.SetTileInListField(tegel.Tile7A,0,0);

        Tile tileA = new Tile(7,7," a ");
        Tile tileB = new Tile(7,7," b ");
        Tile tileC = new Tile(7,7," c ");
        Tile tileD = new Tile(5,5," d ");
        Tile tileE = new Tile(5,5," e ");
        Tile tileF = new Tile(5,5," f ");
        Tile tileG = new Tile(3,3," g ");
        Tile tileH = new Tile(3,3," h ");
        Tile tileI = new Tile(3,3," i ");
        Tile tileJ = new Tile(3,3," j ");
        Tile tileK = new Tile(3,3," k ");
        Tile tileL = new Tile(2,2," l ");

        Grid veld = new Grid(17,17);

        veld.SetTile(tileA, 3, 3);
        veld.SetTile(tileL, 16,16);
        veld.printVeld();
        RowOptionsGenerator rowOptions = new RowOptionsGenerator();
        rowOptions.run();





    }

    /*Waarom zijn bananen krom?
    Als ze recht zijn vallen ze om
    pom pom pom
    ze liggen krom van het lachen*/





}
