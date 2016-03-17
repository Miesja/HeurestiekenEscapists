package com.company;

import java.io.FileReader;
import java.util.*;

public class Main {


    public static void main(String[] args) {
        TileCollection collection = new TileCollection();

        Stack<Grid> fieldStack  = new Stack();
        Grid veld;

        // het maken van een veld van 17x17, gevuld met "0".
        veld = new Grid(17,17);
        fieldStack.push(veld);

        veld.printVeld();
        System.out.println( );

        try {
            Scanner sc = new Scanner(new FileReader("resources/problemA"));
            while (sc.hasNext()) {
                int width = sc.nextInt();
                int length = sc.nextInt();
                String name = " " + sc.next() + " ";
                Tile tile = new Tile(width, length, name);
                collection.tiles.add(tile);
            }
        }
        catch(Exception e){
            System.out.println("FILE NOT FOUND!");
        }


        //Deze functie probeerd alle tiles toe te voegen aan het grid
        for (Tile tile : collection.tiles) {
            Grid currentField = fieldStack.pop();
            Grid newField = currentField.addTile(tile);
            if (newField != null) {
                fieldStack.push(newField);
            }
            else{
                fieldStack.push(currentField);
            }
        }







    }







    /*Waarom zijn bananen krom?
    Als ze recht zijn vallen ze om
    pom pom pom
    ze liggen krom van het lachen*/





}
