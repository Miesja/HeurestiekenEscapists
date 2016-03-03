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


        veld.printVeld();
        System.out.println( );


        // zet een Tile neer op het veld en voegt het nieuwe veld toe aan een stack "fillingFields"
        Grid check = veld.SetTile(tileK,9,9);
        if (check != null) {
            fillingFields.push(check);
        }else{
        System.out.println("de tegel past niet");
        }

        
        fillingFields.peek().printVeld();
        System.out.println( );



        Grid check2 = fillingFields.pop().SetTile(tileB,1,1);
        if (check2 != null) {
            fillingFields.push(check2);
        }else{
            System.out.println("de tegel past niet");
        }

        fillingFields.peek().printVeld();
        System.out.println( );


        Grid check3 = fillingFields.pop().SetTile(tileL,1,12);
        if (check3 !=null){
                fillingFields.push(check3);
        }else{
            System.out.println("de tegel past niet");
        }

        fillingFields.peek().printVeld();
        System.out.println( );



        Options rowOptions = new Options();
        rowOptions.run();






    }


    /*Waarom zijn bananen krom?
    Als ze recht zijn vallen ze om
    pom pom pom
    ze liggen krom van het lachen*/





}
