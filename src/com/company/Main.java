package com.company;

import java.io.FileReader;
import java.util.*;

public class Main {


    public static void main(String[] args) {

        Stack<Grid> fieldStack = new Stack();
        Grid field;

        // maakt het begin Grid (field) en de tegels (tile) van het probleem
        // adhv de waarde die in een txt.file staan (resources/problem"")
        try {
            Scanner sc = new Scanner(new FileReader("resources/problemA"));
            int breedte = sc.nextInt();
            int lengte = sc.nextInt();
            field = new Grid(lengte, breedte);
            while (sc.hasNext()) {
                int width = sc.nextInt();
                int length = sc.nextInt();
                String name = " " + sc.next() + " ";
                Tile tile = new Tile(width, length, name);
                field.collection.tiles.add(tile);
            }
        } catch (Exception e) {
            System.out.println("ERROR!");
            field = new Grid(3, 3);

        }


        fieldStack.push(field);
        field.printVeld();
        System.out.println();



        //Deze functie probeerd alle tiles toe te voegen aan het grid

        while (!fieldStack.isEmpty() && !field.checkIfGridIsFull()) {
            Grid currentField = fieldStack.pop();
            for (Tile tile : currentField.collection.tiles) {
                    Grid newField = currentField.addTile(tile);
                    newField.collection.tiles.remove(tile);
                    if (newField != null) {
                        fieldStack.push(newField);
                    }

            }
        }

        if(!fieldStack.isEmpty()) {
            fieldStack.peek().printVeld();
        }


    }







    /*Waarom zijn bananen krom?
    Als ze recht zijn vallen ze om
    pom pom pom
    ze liggen krom van het lachen*/


    }
