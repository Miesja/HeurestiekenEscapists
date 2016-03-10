package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

public class Main {

    static Stack<Grid> fieldStack  = new Stack();
    static ArrayList<Tile> usedTiles = new ArrayList<>();



    public static void main(String[] args) {
        // het maken van een veld van 17x17, gevuld met "0".
        Grid veld = new Grid(17,17);

        veld.printVeld();
        System.out.println( );


        // de tegels voor het eerste veld.
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

/*
        // zet een Tile neer op het veld en voegt het nieuwe veld toe aan een stack "fieldStack"
        Grid check = veld.SetTile(tileK,9,9);
        if (check != null) {
            fieldStack.push(check);
        }else{
        System.out.println("de tegel past niet");
        }


        fieldStack.peek().printVeld();
        System.out.println( );



        Grid check2 = fieldStack.pop().SetTile(tileB,1,1);
        if (check2 != null) {
            fieldStack.push(check2);
        }else{
            System.out.println("de tegel past niet");
        }

        fieldStack.peek().printVeld();
        System.out.println( );


        Grid check3 = fieldStack.pop().SetTile(tileL,1,12);
        if (check3 !=null){
                fieldStack.push(check3);
        }else{
            System.out.println("de tegel past niet");
        }

        fieldStack.peek().printVeld();
        System.out.println( );*/



       // Options rowOptions = new Options();
       // rowOptions.run();

        createField();
        fieldStack.peek().printVeld();






/*
        for (int x=0; x<veld.breedte; x++) {
            for (int y = 0; y < veld.lengte; y++) {
                if (fieldStack.pop()[y][x] = 0) {
                    Grid newGrid = fieldStack.pop().SetTile(TileX, x, y)
                    if (newGrid != null) {
                        fieldStack.push(newGrid);
                        usedTiles.add(TileX)
                    }
                }
            }
        }

*/


    }

    public static void createField() {
        for (Tile tile : Options.tiles) {
            addTile(tile);
        }
    }

    public static void addTile(Tile tile){
        Grid oldGrid = fieldStack.peek();
        for (int x=1; x<oldGrid.breedte; x++) {
            for (int y = 1; y < oldGrid.lengte; y++) {
                if (fieldStack.peek().field[x][y].equals(" 0 ")) {
                    Grid newGrid = fieldStack.pop().SetTile(tile, x, y);
                    if (newGrid != null) {
                        fieldStack.push(newGrid);
                        usedTiles.add(tile);
                    }
                }
            }
        }
    }


    /*Waarom zijn bananen krom?
    Als ze recht zijn vallen ze om
    pom pom pom
    ze liggen krom van het lachen*/





}
