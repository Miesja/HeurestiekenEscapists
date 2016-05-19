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

    //Haalt een specifieke tile uit de collectie en geeft deze terug zodat er
    // verder mee gewerkt kan worden
    public Tile giveTile(int index){
        Tile x = tiles.get(index);
        return x;
    }

    //Haalt een tile uit de collectie zodat deze niet nogmaals gebruikt kan
    //worden in een Grid
    public void removeFromCollection(Tile tile){
        tiles.remove(tile);
    }

    //Constructor om het veld met lengte l en breedte b, gevuld met " 0 ", te maken.
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

    //Het copiëren van een grid door een grid te maken adhv een andere grid.
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
            /* Dit was:
            for(int y=0; y<lengte; y++){
                field[x][y] = grid.field[x][y];*/
        }
    }

    // kijkt hoeveel lege plekken in een rij
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
    //Plaatst tiles
    public Grid addTile(Tile tile){
        // zoekt het veld (naar de eerste "vrije" x,y coordinaat. en geeft deze door)
        for (int y = 0; y <lengte; y++) {
            for (int x=0; x<breedte; x++) {
                if (field[x][y].equals(" 0 ")) {
                   //de oude "setTile"
                    if (spaceUnoccupied(tile, x, y)) {
                        Grid newGrid = new Grid(this);
                        //vult de plek waar de tegel komt met de "tile.name"
                        for (int i = x; i < (x + tile.width); i++) {
                            for (int j = y; j < (y + tile.length); j++) {
                                newGrid.field[i][j] = tile.name;
                            }
                        }
                        if(draaibaar) {
                            newGrid.removeFromCollection(tile);
                            newGrid.removeFromCollection(tile);
                        }
                        else{
                            newGrid.removeFromCollection(tile);
                        }
                        return newGrid;
                    }else{
                       return null; // meteen de for-loop uit, er is toch geen plaats. (SCHEELT 20% aan RUNTIME!)
                    }
                    // er is geen ruimte voor de tile (if spaceUnoccupied)
                }
                //NIET RETURN NULL, de for-loop is nog bezig.

            }
            //NIET RETURN NULL, de for-loop is nog bezig.
        }
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
                        newGrid.collection.removeFromCollection(tile);
                        newGrid.Xcoordinaat = newGrid.Xcoordinaat+tile.width;
                        return newGrid;
                    }
                }
            }
        }
        return null;
    }

    //Het neerzetten van een tegel (tile.name) in het veld. vanaf coordinaat xPoint en yPoint
    //controleert de plaats waar de tegel neergezet moet worden
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
        if ((XPoint + tile.width) <= breedte && (YPoint+tile.length)<= lengte){
            for (int x = XPoint; x < (XPoint + tile.width); x++) {
                for (int y = YPoint; y < (YPoint + tile.length); y++) {
                    if(field[x][y].equals(" 0 ")){
                        empty++;
                    }
                }
            }
        }
        //Controleert of alle plaatsen leeg zijn
        return empty == (tile.width * tile.length);
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
        return filled == (lengte * breedte);
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
