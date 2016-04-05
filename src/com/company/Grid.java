package com.company;

import java.util.*;

public class Grid {

    //Instance variables.
    int lengte;
    int breedte;
    String[][] field;
    TileCollection collection = new TileCollection();

    //Constructor om het veld met lengte l en breedte b, gevuld met " 0 ", te maken.

    public Grid(int l, int b) {
        lengte = l;
        breedte = b;
        field = new String[breedte][lengte];
            for (int i = 0; i < breedte; i++) {
                for (int j = 0; j < lengte; j++) {
                    field[i][j] = " 0 ";
                }
            }


    }

    //Het copiëren van een grid door een grid te maken adhv een andere grid.
    public Grid(Grid grid) {
        lengte = grid.lengte;
        breedte = grid.breedte;
        field = new String [breedte][lengte];
        for(int i=0; i<grid.collection.tiles.size(); i++){
            collection.tiles.add(grid.collection.giveTile(i));
        }
        for (int i=0; i<breedte; i++){
            for(int j=0; j<lengte; j++){
               field[i][j] = grid.field[i][j];

            }
        }
    }

    // kijkt hoeveel lege plekken in een rij
    public int emptyRowSize() {
        for (int x = 0; x < this.breedte; x++) {
            for (int y = 0; y < this.lengte; y++) {
                if(this.field[x][y].equals(" 0 ")) {
                    int newY = y;
                    while (newY < this.breedte && this.field[x][newY].equals(" 0 ")) {
                        newY++;

                    }
                    int count = newY - y;
                    return count;
                }
            }
        }
        return 0;
    }



                    //Het neerzetten van een tegel (type:Tile) in het veld. op coordinaat xPoint en yPoint
    //controleert de plaats waar de tegel neergezet moet worden
    //en kopieert de laatse tile in de fieldStack om de tile eraan toetevoegen
    //de grid met de tile erop wordt toegevoegd aan de fieldStack
    public Grid SetTile(Tile tegel, int XPoint, int YPoint) {
        if (checkIfUnoccupied(tegel, XPoint, YPoint)) {
            Grid copy = new Grid(this);
            for (int x = XPoint; x < (XPoint + tegel.width); x++) {
                for (int y = YPoint; y < YPoint + tegel.length; y++) {
                        copy.field[x][y] = tegel.name;
                }
            }
            return copy;
        }
        return null;
    }

    //Het printen van het veld.
    public void printVeld() {
        for( int i = 0; i < breedte; i++ ) {
            String Row = "";
            for( int j = 0; j < lengte; j++) {
                String A = field[ i ][ j ];
                Row += A;
            }
            System.out.println( Row );
        }
    }

    //Controleert of er geen tegel ligt waar de nieuwe tegel geplaatst wilt worden
    public boolean checkIfUnoccupied(Tile tile, int XPoint, int YPoint){
        int empty = 0;
        if ((XPoint + tile.width) <= this.breedte && (YPoint+tile.length)<= this.lengte){
            for (int x = XPoint; x < (XPoint + tile.width); x++) {
                for (int y = YPoint; y < (YPoint + tile.length); y++) {
                    String s = field[x][y];
                    if (s.equals(" 0 ")) {
                        empty++;
                    }
                }
            }
        }
        //Controleert of alle plaatsen leeg zijn
        if(empty==(tile.width*tile.length)){
            return true;
        }
        return false;
    }

    //Controleerd of het grid helemaal gevuld is, zo ja, dan wordt true gereturned
    public boolean isFull() {
        int filled = 0;
        for (int c = 0; c < breedte; c++) {
            for (int y = lengte; y < lengte; y++) {
                String s = field[c][y];
                if (!s.equals(" 0 ")) {
                    filled++;
                }
            }
        }
        if(filled==(lengte*breedte)) {
            return true;
        }
        return false;
    }


    //Plaatst tiles
    public Grid addTile(Tile tile){
        for (int x=0; x<this.breedte; x++) {
            for (int y = 0; y < this.lengte; y++) {
                if (this.field[x][y].equals(" 0 ")) {
                    Grid newGrid = this.SetTile(tile, x, y);
                    if (newGrid != null) {
                        newGrid.collection.removeTile(tile);
                        return newGrid;
                    }
                }
            }
        }
        return null;
    }
}
