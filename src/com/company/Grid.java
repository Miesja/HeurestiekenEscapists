package com.company;

import java.util.*;

public class Grid {

    //Instance variables.
    int lengte;
    int Xcoordinaat;
    int breedte;
    String[][] field;
    TileCollection collection = new TileCollection();

    //Constructor om het veld met lengte l en breedte b, gevuld met " 0 ", te maken.
    public Grid(int b, int l) {
        lengte = l;
        breedte = b;
        field = new String[breedte][lengte];
        for (int y = 0; y < lengte; y++) {
            for (int x = 0; x < breedte; x++) {
                field[x][y] = " 0 ";
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
        for(int x=0; x<breedte; x++){
            for(int y=0; y<lengte; y++){
               field[x][y] = grid.field[x][y];

            }
        }
    }

    // kijkt hoeveel lege plekken in een rij
    public int emptyRowSize() {
        for (int y = 0; y < this.lengte; y++) {
            for (int x=0; x<this.breedte; x++) {
                if (this.field[x][y].equals(" 0 ")) {
                    int newX = x;
                    while (newX < this.breedte && this.field[newX][y].equals(" 0 ")) {
                        newX++;

                    }
                    int count = newX - x;
                    return count;
                }
            }
        }
        return 0;
    }
    //Plaatst tiles
    public Grid addTile(Tile tile){
        // zoekt het veld (beginnend in de x-richting bovenaan, naar de eerste "vrije" x,y coordinaat
        for (int y = 0; y <this.lengte; y++) {
            for (int x=0; x<this.breedte; x++) {
                if (this.field[x][y].equals(" 0 ")) {
                   //de oude "setTile"
                    if (spaceUnoccupied(tile, x, y)) {
                        Grid newGrid = new Grid(this);
                        System.out.println("0 - leeg veld");
                        newGrid.printVeld();
                        //newGrid.Xcoordinaat = newGrid.Xcoordinaat+tile.width;
                        //vult de plek waar de tegel komt met de "tile.name"
                        for (int i = x; i < (x + tile.width); i++) {
                            for (int j = y; j < (y + tile.length); j++) {
                                newGrid.field[i][j] = tile.name;
                            }
                        }
                        System.out.println("1 - gevuld veld");
                        newGrid.printVeld();
                       // if(newGrid!= null) {
                            newGrid.collection.removeTile(tile);
                            System.out.println("2 - tile geremoved van grid");
                            newGrid.printVeld();
                            return newGrid;
                        //}
                    }
                    System.out.println("eerste NULL point 1");
                    //return null;
                    // er is geen ruimte voor de tile (if spaceUnoccupied)
                }
                System.out.println("tweede NULL point 2");
                return null;
                    // het veld is vol
            }
            System.out.println("derde NULL point 3");
            return null;
        }
        System.out.println("vierde NULL point 4");
        return null;
    }

/*
    //Plaatst tiles
    public Grid addTile(Tile tile){
        for (int y = 0; y <this.lengte; y++) {
            for (int x=0; x<this.breedte; x++) {
                if (this.field[x][y].equals(" 0 ")) {
                    Grid newGrid = this.SetTile(tile, x, y);
                    if (newGrid != null) {
                        newGrid.collection.removeTile(tile);
                        newGrid.Xcoordinaat = newGrid.Xcoordinaat+tile.width;
                        return newGrid;

                    }
                }
            }
        }
        return null;
    }

    //Het neerzetten van een tegel (type:Tile) in het veld. op coordinaat xPoint en yPoint
    //controleert de plaats waar de tegel neergezet moet worden
    //en kopieert de laatse tile in de fieldStack om de tile eraan toetevoegen
    //de grid met de tile erop wordt toegevoegd aan de fieldStack
    public Grid SetTile(Tile tegel, int XPoint, int YPoint) {
        if (spaceUnoccupied(tegel, XPoint, YPoint)) {
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
*/
    //Controleert of er geen tegel ligt waar de nieuwe tegel geplaatst wilt worden
    public boolean spaceUnoccupied(Tile tile, int XPoint, int YPoint){
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
        for (int x = 0; x < breedte; x++) {
            for (int y = lengte; y < lengte; y++) {
                String s = field[x][y];
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

    //Het printen van het veld.
    public void printVeld(){
        for(int y = 0; y < lengte; y++) {
            for(int x = 0; x < breedte; x++ ) {
                System.out.print(this.field[x][y]);
            }
            System.out.println("");
        }

    }


}
