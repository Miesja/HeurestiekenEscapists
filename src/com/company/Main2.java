    package com.company;

    import java.io.FileReader;
    import java.util.*;
public class Main2 {

    public static void main (String[]args){



        boolean draaibaar =true;

        GI graphSolution = new GI();

        for(int c = 0; c<100; c++) {
            Stack<Grid> fieldStack = new Stack();
            Grid field;
            Grid printGrid;
            Grid startOptionsField;
            String[][] testGrid;
            Stack<Grid> solutions = new Stack();


            // maakt het begin Grid (field) en de tegels (tile) van het probleem
            // adhv de waarde die in een txt.file staan (resources/problem"")
            try {
                Scanner sc = new Scanner(new FileReader("resources/problemC"));
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
                    field.tiles.add(tile1);
                    if (draaibaar) {
                        Tile tile2 = new Tile(length, width, name, true);
                        field.tiles.add(tile2);
                    }
                }
            } catch (Exception e) {
                System.out.println("ERROR!");
                field = null;
            }
            if (field != null) {
                fieldStack.push(field);
            }
/*
            for (Tile tile : field.collection.tiles) {
               // System.out.println(tile.name + " " + tile.turned);
            }
*/
            //klok kijken: begint voor het maken van de combi's
            long combiTime = System.nanoTime();

            //maakt de combi opties en slaat deze op in een 2D Array <Opties<opties<combi van tiles>>>

            Options opties = new Options(field.breedte, field.tiles, draaibaar);


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
            for (ArrayList<Tile> option : opties.options ) {
                Grid usefield = new Grid(field);
                for (Tile tile : option) {
                    usefield = usefield.addTile(tile);
                }
                if (usefield != null) {
                    fieldStack.push(usefield);
                }
            }

            //    int runTimeSec = (total)/(1*10^9);
            //    System.out.println(runTimeSec);


            //Zoekt naar oplossing mbv tegel voor tegel depth-first search

            while (!fieldStack.isEmpty()) {
                Grid currentField = fieldStack.pop();
                for (int i = 0; i < currentField.tiles.size(); i++) {
                    Tile tile = currentField.giveTile(i);
                    Grid newField = currentField.addTile(tile);
                    if (newField != null) {
                        newField.removeFromCollection(tile);
                        fieldStack.push(newField);
                        if (fieldStack.peek().tiles.isEmpty()) {
                            GI.field = fieldStack.peek().field;
                            graphSolution.go();
                            System.out.println("solution Found!");
                            while (!fieldStack.isEmpty()) {
                                fieldStack.pop();
                            }
                        }
                    }

                }
            }

            long endTime = System.nanoTime();
            long total = endTime - startTime;
            long solutionTime = total + combiRunTime;
            //System.out.println("vullen van het veld met tiles - RunTime: " + total + " nano seconden");
            System.out.println("Oplossing gevonden in totale  - RunTime: " + solutionTime + " nano seconden");


        }
    }
}

