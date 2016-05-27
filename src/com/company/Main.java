package com.company;

import java.io.FileReader;
import java.util.*;

public class Main {


    public static void main(String[] args) {

        // adjust the number of cycles you wish the program to run.
        for (int c = 0; c < 1; c++) {
            boolean turnable = true; //change whether turning the tiles should be allowed or not
            long total = 0;
            long solutionTime = 0;
            ArrayList<Tile> Tiles = new ArrayList<>();

            GI graphSolution = new GI();

            boolean solution = false;

                Stack<Grid> fieldStack = new Stack();
                Grid field;


                // makes the starting grid (field) and the Tiles of the problem set
                // based on the data collected from the textfile "resources/problem[problemnumber/letter] "
                try {
                    Scanner sc = new Scanner(new FileReader("resources/problem19a")); //change the problem
                    int FieldWidth = sc.nextInt();
                    int FieldLength = sc.nextInt();
                    field = new Grid(FieldWidth, FieldLength, turnable);
                    System.out.println("");
                    while (sc.hasNext()) {
                        int width = sc.nextInt();
                        int length = sc.nextInt();
                        String name = " " + sc.next() + " ";
                        Tile tile1 = new Tile(width, length, name, false);
                        field.tiles.add(tile1);
                        Tiles.add(tile1);
                        if (turnable) {
                            Tile tile2 = new Tile(length, width, name, true);
                            field.tiles.add(tile2);
                            Tiles.add(tile2);
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
                // prints out the name of each tile and wether it has been turned
                for(Tile tile : field.collection.tiles){
                    System.out.println(tile.name + " " + tile.turned);
                }
    */
                //CountingClock: begins before generating the intial combination option.
                long combiTime = System.nanoTime();

                //searches through the tiles available for the "biggest Tile" to use for the firstRow option
                Tile biggestTile = new Tile(0, 0, "xx", false);
                for (Tile tile : field.tiles) {
                    if (tile.width > biggestTile.width) {
                        biggestTile = tile;
                    }
                }

                while (!solution) {
                    Tiles.remove(biggestTile);

                    /*  Generates the possible options to fill the first Row,
                        using the BiggestTile as the first Tile placed on the Grid. */
                    Options opties = new Options(field.width, field.tiles, biggestTile, turnable);

                    // Counts the amount of cycles
                    System.out.print("Cyclus nr: " +c + " ");
                    System.out.println("");

                    // Counts the number of initial options possible with the tiles.
                    int nCombinatie;
                    nCombinatie = opties.options.size();
                    System.out.print("The number of initial options is: " + nCombinatie);
                    System.out.println("");

                    //CountingClock: measures how long it takes to generate the inital Tile combination options.
                    long endCombi = System.nanoTime();
                    long combiRunTime = endCombi - combiTime;
                    System.out.println("Making of tile options - Runtime :" + combiRunTime + " nano seconds");

                    //CountingClock: begins before the generated options are added to the stack. (for the search)
                    long startTime = System.nanoTime();

                    // combi-options added to the stack.
                    for (ArrayList<Tile> option : opties.options) {
                        Grid usefield = new Grid(field);
                        for (Tile tile : option) {
                            usefield = usefield.addTile(tile);
                        }
                        if (usefield != null) {
                            fieldStack.push(usefield);
                        }
                    }

                    // looks for a solution through a depth-first search
                    // by using combi-options to fill up the available empty space
                    int space;
                    while (!fieldStack.isEmpty()) {
                        Grid currentfield = fieldStack.pop();

                        // The last field in the fieldstack is the empty field, which should not be used when looking
                        // for a solution.
                        if(currentfield.isEmpy()){
                            break;
                        }
                        if (currentfield != null) {
                            space = currentfield.emptyRowSize();
                            if (space == 0) {
                                fieldStack.push(currentfield);
                                break;
                            }
                            // generates combi-options for the available empty space on the grid.
                            Options fillspace = new Options(space, currentfield.tiles, turnable);
                            if (fillspace.options.isEmpty()) {
                                continue;
                            }
                            for (ArrayList<Tile> spaceOption : fillspace.options) {
                                Grid newField = new Grid(currentfield);
                                for (Tile tile : spaceOption) {
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

                    // searches for the next biggest tile to fill the first row,
                    // if using the biggestTile gave no solution.
                    if (fieldStack.isEmpty()) {
                        if (!Tiles.isEmpty()) {
                            Tile nextBiggest = new Tile(0, 0, "xxx", false);
                            for (Tile tile : Tiles) {
                                if (tile.width > nextBiggest.width) {
                                    nextBiggest = tile;
                                }
                            }
                            System.out.println("New biggestTile is " +nextBiggest.name + nextBiggest.turned);
                            biggestTile = nextBiggest;
                        } else {
                            System.out.println("No solution found");
                            return;
                        }
                    // concludes the program after finding a solution!
                    // prints out runTimes and a graphic representation of the solution.
                    } else {
                        long endTime = System.nanoTime();
                        total = endTime - startTime;
                        solutionTime = total + combiRunTime;
                        System.out.println("Completely filling the field with tiles - RunTime: " + total + " nano seconds");
                        System.out.println("Solution found in total  - RunTime: " + solutionTime + " nano seconds");
                        System.out.println("");
                        System.out.println("The TileSetter-solution!");
                        fieldStack.peek().printVeld();

                        GI.field = fieldStack.peek().field;
                        graphSolution.go();
                        solution = true;
                    }
                }
            }
        }
    }

