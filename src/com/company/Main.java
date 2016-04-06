package com.company;

import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Stack<Grid> fieldStack = new Stack();
        Grid field;
        Grid startOptionsField;
        String[][] testGrid;


        // maakt het begin Grid (field) en de tegels (tile) van het probleem
        // adhv de waarde die in een txt.file staan (resources/problem"")
        try {
            Scanner sc = new Scanner(new FileReader("resources/problemB"));
            int breedte = sc.nextInt();
            int lengte = sc.nextInt();
            field = new Grid(breedte, lengte);
            field.printVeld();
            System.out.println("");
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
/*
        Grid tryGrid;
        tryGrid = field;
        Grid copy;
        tryGrid.printVeld();
        System.out.println("");
        int tileCollection;
        tileCollection = field.collection.tiles.size();
        System.out.print("the number of tiles is: " + tileCollection);
        System.out.println("");

        copy = tryGrid.addTile(field.collection.tiles.get(2));
        copy.printVeld();
        System.out.println("");
        Grid two;
        two=copy.addTile(field.collection.tiles.get(3));
        two.printVeld();

*/



        Options opties = new Options(field.breedte, field.collection);

        /*for (int i = 0; i < opties.options.size(); i++) {
            System.out.print("[");
            for (int j = 0; j < opties.options.get(i).size(); j++) {
                System.out.print(opties.options.get(i).get(j).name + ", ");
            }
            System.out.print("], ");
        }*/


        // combi-options toegevoegd aan de stack.
        for (int j = 0; j < opties.options.size(); j++) {
            Grid usefield = new Grid(field);
            for (Tile tile : opties.options.get(j)) {
                usefield = usefield.addTile(tile);
            }
            if (usefield != null) {
                fieldStack.push(usefield);
            }
        }


        /*System.out.println("");
        int nCombinatie;
        nCombinatie = fieldStack.size() - 1;
        System.out.print("Het aantal combinaties is: " + nCombinatie);
        System.out.println("");
        System.out.println("");
        fieldStack.peek().printVeld();*/




        // find a solution with the help of options
        int space = field.breedte;
        while(!fieldStack.isEmpty()){
            Grid currentfield = fieldStack.pop();
            if(currentfield!=null) {
                space = currentfield.emptyRowSize();
                if(space==0){
                    fieldStack.push(currentfield);
                    break;
                }
                Options fillspace = new Options(space, currentfield.collection);
                if(fillspace.options.isEmpty()){
                    fieldStack.pop();
                }
                for (int j = 0; j < fillspace.options.size(); j++) {
                    Grid newField = new Grid(currentfield);
                    for (Tile tile : fillspace.options.get(j)) {
                        newField = newField.addTile(tile);
                    }
                    if(newField!=null){
                        fieldStack.push(newField);
                    }
                }
            }
        }

        fieldStack.peek().printVeld();
        System.out.println(space);



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




    /*Waarom zijn bananen krom?
    Als ze recht zijn vallen ze om
    pom pom pom
    ze liggen krom van het lachen*/


    }
}

