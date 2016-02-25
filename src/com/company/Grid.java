package com.company;

/**
 * Created by Bas on 25-2-2016.
 */
public class Grid {


    //Tile tegel = new Tile;
    int lengte;
    int breedte;
    String[][] field;

    public Grid ( int l, int b)
    {
        lengte = l;
        breedte = b;
        field = new String [lengte][breedte];
    }

    // het neerzetten van de tegel in de grid.
    public void SetTile(Tile tegel, int XPoint, int YPoint) {
        for (int x = XPoint; x < (XPoint + tegel.width); x++) {
            for (int y = YPoint; y < YPoint + tegel.length; y++) {
                field[x][y] = tegel.name;
            }
        }
    }


    // het printen van het veld.
    public void printVeld()
    {
        for( int i = 0; i < lengte; i++ )
        {
            String Row = "";
            for( int j = 0; j < breedte; j++)
            {
                String A = field[ i ][ j ];
                Row += A;
            }
            System.out.println( Row );
        }
    }
}
