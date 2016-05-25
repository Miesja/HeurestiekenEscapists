package com.company;

import java.util.*;

public class Grid {

    //Instance variables.
    boolean draaibaar;
    int lengte;
    int Xcoordinaat;
    int breedte;
    String[][] field;

    ArrayList<Tile> tiles = new ArrayList<>();

    // takes a Tile out of the collection and returns it for use.
    public Tile giveTile(int index){
        Tile x = tiles.get(index);
        return x;
    }

    // removes a Tile from the collection to make sure it can't be used again.
    public void removeFromCollection(Tile tile){
        tiles.remove(tile);
    }

    // Constructor to make the starting grid (filled with "0")
    public Grid(int b, int l, boolean draai) {
        draaibaar = draai;
        lengte = l;
        breedte = b;
        field = new String[breedte][lengte];
        for (int y = 0; y < lengte; y++) {
            for (int x = 0; x < breedte; x++) {
                field[x][y] = " 0 ";
            }
        }
    }

    // a method to copy a Grid, including the Tiles.
    public Grid(Grid grid) {
        draaibaar = grid.draaibaar;
        lengte = grid.lengte;
        breedte = grid.breedte;
        field = new String [breedte][lengte];
        for(int i=0; i<grid.tiles.size(); i++){
            tiles.add(grid.giveTile(i));
        }
        for(int x=0; x<breedte; x++){
            System.arraycopy(grid.field[x], 0, field[x], 0, lengte);
        }
    }

    // a method to calculate how many consecutive spaces there are in a row
    // this "count" will be used to generate options to fill the emptyRow
    public int emptyRowSize() {
        for (int y = 0; y < lengte; y++) {
            for (int x=0; x<breedte; x++) {
                if (field[x][y].equals(" 0 ")) {
                    int newX = x;
                    while (newX < breedte && field[newX][y].equals(" 0 ")) {
                        newX++;
                    }
                    int count = newX - x;
                    return count;
                }
            }
        }
        return 0;
    }

    // a method that places a Tile onto the Grid.
    public Grid addTile(Tile tile){
        // searches the Grid for the x and y coordinates of the first available space
        for (int y = 0; y <lengte; y++) {
            for (int x=0; x<breedte; x++) {
                if (field[x][y].equals(" 0 ")) {
                    // checks to see if there is enough available space to place the Tile
                    if (spaceUnoccupied(tile, x, y)) {
                        Grid newGrid = new Grid(this);
                        // fills the space in the Grid with the Tile.name
                        for (int i = x; i < (x + tile.width); i++) {
                            for (int j = y; j < (y + tile.length); j++) {
                                newGrid.field[i][j] = tile.name;
                            }
                        }
                        // removes the Tile and it's "turned" duplicate from the collection.
                        if(draaibaar) {
                            newGrid.removeFromCollection(tile);
                            Tile turned = tile.turnTile();
                            newGrid.removeFromCollection(turned);
                        }
                        // removes the Tile, placed on the grid, from the collection.
                        else{
                            newGrid.removeFromCollection(tile);
                        }
                        return newGrid;
                    }else{
                       return null;
                    }
                }
            }
        }
        return null;
    }

    // checks if the space on the grid where you want to place the Tile is unoccupied
    // by counting the "0" on the grid where the Tile will be placed.
    public boolean spaceUnoccupied(Tile tile, int XPoint, int YPoint){
        int empty = 0;
        if ((XPoint + tile.width) <= breedte && (YPoint+tile.length)<= lengte){
            for (int x = XPoint; x < (XPoint + tile.width); x++) {
                for (int y = YPoint; y < (YPoint + tile.length); y++) {
                    if(field[x][y].equals(" 0 ")){
                        empty++;
                    }
                }
            }
        }
        // if the "0" counted match the space needed by the Tile, it returns true.
        return empty == (tile.width * tile.length);
    }

    // Checks to see if the Grid is full by counting the "0" (empty spaces) on the Grid
    // if there are none, the grid is full and it returns true.
    public boolean isFull() {
        int filled = 0;
        for (int x = 0; x < breedte; x++) {
            for (int y = lengte; y < lengte; y++) {
                String s = field[x][y];
                if (!s.equals(" 0 ")) {
                    filled++;
                }
            }
        }
        return filled == (lengte * breedte);
    }

    // a method that prints the Grid
    // Tiles placed are shown by their name, empty spaces are "0"
    public void printVeld(){
        for(int y = 0; y < lengte; y++) {
            for(int x = 0; x < breedte; x++ ) {
                System.out.print(this.field[x][y]);
            }
            System.out.println("");
        }
    }
}
