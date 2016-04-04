package com.company;

import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Stack<Grid> fieldStack = new Stack();
        Grid field;
        Grid startOptionsField;

        // maakt het begin Grid (field) en de tegels (tile) van het probleem
        // adhv de waarde die in een txt.file staan (resources/problem"")
        try {
            Scanner sc = new Scanner(new FileReader("resources/problemA"));
            int breedte = sc.nextInt();
            int lengte = sc.nextInt();
            field = new Grid(lengte, breedte);
            //field.printVeld();
            //System.out.println("");
            while (sc.hasNext()) {
                int width = sc.nextInt();
                int length = sc.nextInt();
                String name = " " + sc.next() + " ";
                Tile tile = new Tile(width, length, name);
                field.collection.tiles.add(tile);
            }
        } catch (Exception e) {
            System.out.println("ERROR!");
            field = null;

        }
        if (field != null) {
            fieldStack.push(field);
        }
        fieldStack.peek().printVeld();

        Options opties = new Options(field);
        opties.makeOptions(field.collection);
        for (int i = 0; i < opties.options.size(); i++) {
            System.out.print("[");
            for (int j = 0; j < opties.options.get(i).size(); j++) {
                System.out.print(opties.options.get(i).get(j).width + ", ");
            }
            System.out.print("], ");
        }


        // combi-options toegevoegd aan de stack.
       for (int j=0; j< opties.options.size(); j++) {
           Grid usefield = new Grid(field);
           for (Tile tile : opties.options.get(j)) {
               usefield = usefield.addTile(tile);
           }
           System.out.println();
           usefield.printVeld();
           if (field != null) {
               fieldStack.push(field);
           }
       }
       System.out.println();
       fieldStack.peek().printVeld();


        //Deze functie probeerd alle tiles toe te voegen aan het grid
/*
        while (!fieldStack.isEmpty()) {
            Grid currentField = fieldStack.pop();
            for (int i = 0; i < currentField.collection.tiles.size(); i++) {
                Tile tile = currentField.collection.giveTile(i);
                Grid newField = currentField.addTile(tile);
                if (newField != null) {
                    System.out.println();
                    newField.printVeld();
                    newField.collection.removeTile(tile);
                    fieldStack.push(newField);
                    if (fieldStack.peek().collection.tiles.isEmpty()) {
                        System.out.println();
                        fieldStack.peek().printVeld();
                        while (!fieldStack.isEmpty()) {
                            fieldStack.pop();
                        }
                    }
                }

            }
        }

        if (!fieldStack.isEmpty()) {
            fieldStack.peek().printVeld();
        }*/
    }

    /*Waarom zijn bananen krom?
    Als ze recht zijn vallen ze om
    pom pom pom
    ze liggen krom van het lachen*/

}
