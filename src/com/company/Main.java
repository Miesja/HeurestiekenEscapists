package com.company;

import java.io.FileReader;
import java.util.*;

public class Main {


    public static void main(String[] args) {
        TileCollection collection = new TileCollection();

        Stack<Grid> fieldStack  = new Stack();
        Grid field;

        // maakt het begin Grid (field) en de tegels (tile) van het probleem
        // adhv de waarde die in een txt.file staan (resources/problem"")
        try {
            Scanner sc = new Scanner(new FileReader("resources/problemB"));
            int breedte = sc.nextInt();
            int lengte = sc.nextInt();
            field = new Grid(lengte, breedte);
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
            field = new Grid(3,3);

        }

        fieldStack.push(field);
        field.printVeld();
        System.out.println( );


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

        fieldStack.peek().printVeld();








    }







    /*Waarom zijn bananen krom?
    Als ze recht zijn vallen ze om
    pom pom pom
    ze liggen krom van het lachen*/





}
