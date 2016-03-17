package com.company;

import java.util.*;


public class Grid {

    //Instance variables.
    int lengte;
    int breedte;
    String[][] field;

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
        for (int i=0; i<breedte; i++){
            for(int j=0; j<lengte; j++){
               field[i][j] = grid.field[i][j];

            }
        }
    }


    //Het neerzetten van een tegel (type:Tile) in het veld. op coordinaat xPoint en yPoint
    //controleert de plaats waar de tegel neergezet moet worden
    //en kopieert de laatse tile in de fieldStack om de tile eraan toetevoegen
    //de grid met de tile erop wordt toegevoegd aan de fieldStack
    public Grid SetTile(Tile tegel, int XPoint, int YPoint) {
        if (controleerPlaats(tegel, XPoint, YPoint)) {
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
    public boolean controleerPlaats(Tile tegel, int XPoint, int YPoint){
        boolean vrij;
        int klopt = 0;
        if ((XPoint + tegel.width) < this.breedte && (YPoint+tegel.width)< this.lengte){
            for (int x = XPoint; x < (XPoint + tegel.width); x++) {
                for (int y = YPoint; y < (YPoint + tegel.length); y++) {
                    System.out.println(tegel.name);
                    String s = field[x][y];
                    if (s.equals(" 0 ")) {
                        klopt++;
                    }
                }
            }
        }

        //Controleert of alle plaatsen leeg zijn
        if(klopt==(tegel.width*tegel.length)){
            vrij = true;
        }
        else {
            vrij = false;
        }
        return vrij;
    }



    //Plaatst tiles
    public Grid addTile(Tile tile){
        for (int x=0; x<this.breedte; x++) {
            for (int y = 0; y < this.lengte; y++) {
                if (this.field[x][y].equals(" 0 ")) {
                    Grid newGrid = this.SetTile(tile, x, y);
                    if (newGrid != null) {
                        return newGrid;
                    }
                }
            }
        }
        return null;
    }
}
