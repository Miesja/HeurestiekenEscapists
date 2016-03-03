package com.company;

import java.util.ArrayList;
import java.util.Stack;

public class Main {

    static ArrayList<Grid> velden = new ArrayList<>();
    static Stack<Grid> fillingFields  = new Stack();



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


/*
        velden.get(velden.size()-1).SetTile(tileA, 3, 3);
        velden.get(velden.size()-1).printVeld();
        velden.get(velden.size()-1).SetTile(tileK,10,10);
        velden.get(velden.size()-1).printVeld();
*/
        veld.printVeld();

        fillingFields.push(veld.SetTile(tileK,9,9));
        System.out.println( );

        fillingFields.peek().printVeld();
        System.out.println( );

        fillingFields.push(fillingFields.pop().SetTile(tileB,5,5));

        fillingFields.peek().printVeld();
        System.out.println( );

        System.out.println( );

        System.out.println( );
        fillingFields.peek().printVeld();


        Options rowOptions = new Options();
        rowOptions.run();


        fillingFields.push(veld);




    }


    /*Waarom zijn bananen krom?
    Als ze recht zijn vallen ze om
    pom pom pom
    ze liggen krom van het lachen*/





}
