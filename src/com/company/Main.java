package com.company;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // het maken van een veld van 17x17, gevuld met "0".
        Grid veld = new Grid(17,17);

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


        veld.SetTile(tileA, 3, 3);
        veld.SetTile(tileL, 16,16);
        veld.printVeld();
        options rowOptions = new options();
        rowOptions.run();
    }

    /*Waarom zijn bananen krom?
    Als ze recht zijn vallen ze om
    pom pom pom
    ze liggen krom van het lachen*/





}
