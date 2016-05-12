package com.company;

import java.io.FileReader;
import java.util.*;

public class Main {


    public static void main(String[] args) {

        boolean draaibaar = false;
        long total = 0;
        long solutionTime = 0;


        GI graphSolution = new GI();

        boolean solution = false;

        //for(int c = 0; c<100; c++) {
            Stack<Grid> fieldStack = new Stack();
            Grid field;


            // maakt het begin Grid (field) en de tegels (tile) van het probleem
            // adhv de waarde die in een txt.file staan (resources/problem"")
            try {
                Scanner sc = new Scanner(new FileReader("resources/problem2"));
                int breedte = sc.nextInt();
                int lengte = sc.nextInt();
                field = new Grid(breedte, lengte, draaibaar);
                //field.printVeld();
                System.out.println("");
                while (sc.hasNext()) {
                    int width = sc.nextInt();
                    int length = sc.nextInt();
                    String name = " " + sc.next() + " ";
                    Tile tile1 = new Tile(width, length, name, false);
                    field.collection.tiles.add(tile1);
                    if(draaibaar) {
                        Tile tile2 = new Tile(length, width, name, true);
                        field.collection.tiles.add(tile2);
                    }
                }
            } catch (Exception e) {
                System.out.println("ERROR!");
                field = null;
            }
            if (field != null) {
                fieldStack.push(field);
            }

            for(Tile tile : field.collection.tiles){
                System.out.println(tile.name + " " + tile.turned);
            }

            //klok kijken: begint voor het maken van de combi's

            //maakt de combi opties en slaat deze op in een 2D Array <Opties<opties<combi van tiles>>>
            Tile biggestTile = new Tile(0,0, "xx", false);
            for(Tile tile : field.collection.tiles){
                if(tile.width>biggestTile.width){
                    biggestTile = tile;
                }
            }

            while(!solution) {
                long combiTime = System.nanoTime();

                Options opties = new Options(field.breedte, field.collection, biggestTile, draaibaar);


                // telt het aantal combinaties
                int nCombinatie;
                nCombinatie = opties.options.size();
                System.out.print("Het aantal combinaties is: " + nCombinatie);
                System.out.println("");

                //Klok kijken: meet hoelang het maken van de combinaties duurt
                long endCombi = System.nanoTime();
                long combiRunTime = endCombi - combiTime;
                System.out.println("Maken van de tile combinaties - Runtime :" + combiRunTime + " nano seconden");


                // print de gemaakte combi-opties uit.
    /*        for (int i = 0; i < opties.options.size(); i++) {
                System.out.print("[");
                for (int j = 0; j < opties.options.get(i).size(); j++) {
                    System.out.print(opties.options.get(i).get(j).name + ", ");
                }
                System.out.print("], ");
            }
    */


                //klok kijken: begint voor je de combi's toevoegd aan de stack (voor de depth-first)
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
                        Options fillspace = new Options(space, currentfield.collection, draaibaar);
                        if (fillspace.options.isEmpty()) {
                            continue;
                        }
                        for (int j = 0; j < fillspace.options.size(); j++) {
                            Grid newField = new Grid(currentfield);
                            for (Tile tile : fillspace.options.get(j)) {
                                //System.out.println("aantal opties " + fillspace.options.size());
                                if (newField == null) {
                                    break;
                                }
                                newField = newField.addTile(tile);
                            }
                            if (newField != null) {
                                fieldStack.push(newField);
                            }
                        }
                    }
                }

                // Zoek naar de een (of twee, drie etc) na grootste tegel:
                // Eerst alle tegels die kleiner zijn dan de huidige eerste tegel
                ArrayList<Tile> smallerTiles = new ArrayList<>();
                if (fieldStack.isEmpty()) {
                    for(Tile tile : field.collection.tiles){
                        if(tile.width<biggestTile.width){
                            smallerTiles.add(tile);
                        }
                    }
                    // Er zijn geen kleinere tegels, dus: alles al geprobeerd
                    if(smallerTiles.isEmpty()){
                        System.out.println("geen oplossing");
                        solution = true;
                    }
                    // Vind de grootste tegel van de kleinere tegels
                    Tile nextBiggest = new Tile(0,0, "xxx", false);
                    for (Tile tile : smallerTiles){
                        if(tile.width>nextBiggest.width){
                            nextBiggest = tile;
                        }
                    }
                    System.out.println(nextBiggest.name);
                    biggestTile = nextBiggest;
                }
                else {
                    long endTime = System.nanoTime();
                    total = endTime - startTime;
                    solutionTime = total + combiRunTime;
                    System.out.println("vullen van het veld met tiles - RunTime: " + total + " nano seconden");
                    System.out.println("Oplossing gevonden in totale  - RunTime: " + solutionTime +" nano seconden");
                    System.out.println("");
                    System.out.println("de oplossing van het tegelzetten!");
                    fieldStack.peek().printVeld();

                    graphSolution.field = fieldStack.peek().field;
                    graphSolution.go();
                    solution = true;

                }
            }



            }




            //    int runTimeSec = (total)/(1*10^9);
            //    System.out.println(runTimeSec);





        /*Waarom zijn bananen krom?
        Als ze recht zijn vallen ze om
        pom pom pom
        ze liggen krom van het lachen*/
       // }


    }

