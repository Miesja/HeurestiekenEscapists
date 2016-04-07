package com.company;

import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {

      //  while(true) {
            Stack<Grid> fieldStack = new Stack();
            Grid field;
            Grid printGrid;
            Grid startOptionsField;
            String[][] testGrid;


            // maakt het begin Grid (field) en de tegels (tile) van het probleem
            // adhv de waarde die in een txt.file staan (resources/problem"")
            try {
                Scanner sc = new Scanner(new FileReader("resources/problemA"));
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

            //maakt de combi opties en slaat deze op in een 2D Array <Opties<opties<combi van tiles>>>
            Options opties = new Options(field.breedte, field.collection);

        // print de gemaakte combi-opties uit.
            /*for (int i = 0; i < opties.options.size(); i++) {
                System.out.print("[");
                for (int j = 0; j < opties.options.get(i).size(); j++) {
                    System.out.print(opties.options.get(i).get(j).name + ", ");
                }
                System.out.print("], ");
            }*/


            // testen met de nieuwe addTile functie (alles-in-1 versie)
     /*     printGrid = new Grid(field);
            printGrid = printGrid.addTile(field.collection.tiles.get(10));

            System.out.println("printen van printGrid vanuit MAIN (returned from de addTile)");
            printGrid.printVeld();
            printGrid = printGrid.addTile(field.collection.tiles.get(4));
            System.out.println("printen van printGrid vanuit MAIN (2e return uit de addTile)");
            printGrid.printVeld();
    */


            //klok kijken (begint wanneer je begint met zoeken naar oplossingen
            long startTime = System.nanoTime();

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

/*            // telt het aantal combinaties en print de bovenste combi-Grid in de stack
            int nCombinatie;
            nCombinatie = fieldStack.size() - 1;
            System.out.println("");
            System.out.print("Het aantal combinaties is: " + nCombinatie);
            System.out.println("");
            System.out.println("");
            fieldStack.peek().printVeld();
*/

            // zoekt naar een oplossing mbv combi-opties depth-first search
            int space = field.breedte;
            while (!fieldStack.isEmpty()) {
                Grid currentfield = fieldStack.pop();
                if (currentfield != null) {
                    space = currentfield.emptyRowSize();
                    if (space == 0) {
                        fieldStack.push(currentfield);
                        break;
                    }
                    Options fillspace = new Options(space, currentfield.collection);
                    if (fillspace.options.isEmpty()) {
                        fieldStack.pop();
                    }
                    for (int j = 0; j < fillspace.options.size(); j++) {
                        Grid newField = new Grid(currentfield);
                        for (Tile tile : fillspace.options.get(j)) {
                            newField = newField.addTile(tile);
                        }
                        if (newField != null) {
                            fieldStack.push(newField);
                        }
                    }
                }
            }

            // klok kijken: geeft de nanoseconden die het zoeken naar de oplossing heeft geduurd.
            long endTime = System.nanoTime();
            System.out.println("de oplossing van het tegelzetten!");
            fieldStack.peek().printVeld();
            System.out.println("");
            long total = endTime - startTime;
            System.out.println("de RunTime: " + total + "nano seconden");
            //    int runTimeSec = (total)/(1*10^9);
            //    System.out.println(runTimeSec);




            //Zoekt naar oplossing mbv tegel voor tegel depth-first search
        /*    while (!fieldStack.isEmpty()) {
                Grid currentField = fieldStack.pop();
                for (int i = 0; i < currentField.collection.tiles.size(); i++) {
                    Tile tile = currentField.collection.giveTile(i);
                    Grid newField = currentField.addTile(tile);
                    if (newField != null) {
                        newField.collection.removeTile(tile);
                        fieldStack.push(newField);
                        if (fieldStack.peek().collection.tiles.isEmpty()) {
                            while (!fieldStack.isEmpty()) {
                                fieldStack.pop();
                            }
                        }
                    }

                }
            }

            if (!fieldStack.isEmpty()) {
                fieldStack.peek().printVeld();
            }


    */

        /*Waarom zijn bananen krom?
        Als ze recht zijn vallen ze om
        pom pom pom
        ze liggen krom van het lachen*/
        }


   // }
}

