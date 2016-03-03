package com.company;

/**
 * Created by Bas on 25-2-2016.
 */
public class Grid {

    //instance variables.
    int lengte;
    int breedte;
    String[][] field;

    // Constructor om het veld met lengte l en breedte b, gevuld met "0", te maken.

    public Grid(int l, int b) {
        lengte = l;
        breedte = b;
        field = new String[lengte][breedte];

        if (Main.fillingFields.empty()){
      //  if (Main.velden.isEmpty()) {
            for (int i = 0; i < lengte; i++) {
                for (int j = 0; j < breedte; j++) {
                    field[i][j] = " 0 ";
                 //   Main.velden.add(this);
                    Main.fillingFields.push(this);
                }
            }
        }
    }

    public Grid(Grid grid) {
        lengte = grid.lengte;
        breedte = grid.breedte;
        field = new String [lengte][breedte];
        for (int i=0; i<lengte; i++){
           for(int j=0; j<breedte; j++){
               field[i][j] = grid.field[i][j];

            }
        }

    }


    // het neerzetten van een tegel (type:Tile) in het veld. op coordinaat xPoint en yPoint
    public Grid SetTile(Tile tegel, int XPoint, int YPoint) {
       // Main.velden.add(Main.velden.get(Main.velden.size() - 1));
        //Main.fillingFields.push(Main.fillingFields.peek());
        Grid copy = new Grid (this);
        //Main.fillingFields.push(copy);

        for (int x = XPoint-1; x < (XPoint-1 + tegel.width); x++) {
            for (int y = YPoint-1; y < YPoint-1 + tegel.length; y++) {
                if (controleerPlaats(x,y)) {
                    //    Main.velden.get(Main.velden.size()-1).field [x][y] = tegel.name;
                    copy.field[x][y] = tegel.name;
                }
            }
        }
        return copy;
    }


    // het printen van het veld.
    public void printVeld() {
        for( int i = 0; i < lengte; i++ ) {
            String Row = "";
            for( int j = 0; j < breedte; j++) {
                String A = field[ i ][ j ];
                Row += A;
            }
            System.out.println( Row );
        }
    }

    // controleert of er geen tegel ligt waar de nieuwe tegel geplaatst wilt worden
    public boolean controleerPlaats( int x, int y){
        String s = field[x][y];
        boolean vrij;
        if(s.equals(" 0 ")){
            vrij = true;
        }
        else{
            vrij = false;
        }

        return vrij;
    }
}
