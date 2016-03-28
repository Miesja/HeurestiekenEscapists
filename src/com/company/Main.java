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
            Scanner sc = new Scanner(new FileReader("resources/testProblem"));
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
        if(field!=null) {
            fieldStack.push(field);
        }
        fieldStack.peek().printVeld();
        while(!fieldStack.empty()) {
            if(fieldStack.peek().solution){
                fieldStack.peek().printVeld();
                break;
            }
            ArrayList<Grid> children = fieldStack.pop().createChildren();
            for(Grid child: children){
                fieldStack.push(child);
            }
        }
        if(fieldStack.empty()){
            System.out.println("no solution found");
        }



        //Deze functie probeerd alle tiles toe te voegen aan het grid

        /*while (!fieldStack.isEmpty()) {
            Grid currentField = fieldStack.pop();
            for (int i = 0; i < currentField.collection.tiles.size(); i++) {
                Tile tile = currentField.collection.giveTile(i);
                Grid newField = currentField.addTile(tile);
                newField.collection.removeTile(tile);
                if (newField != null) {
                    fieldStack.push(newField);
                }
                fieldStack.peek().printVeld();
                System.out.println();
            }

        }

        if(!fieldStack.isEmpty()) {
            fieldStack.peek().printVeld();
        }
        */


    }







    /*Waarom zijn bananen krom?
    Als ze recht zijn vallen ze om
    pom pom pom
    ze liggen krom van het lachen*/


    }
