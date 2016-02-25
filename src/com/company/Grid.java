package com.company;

/**
 * Created by Bas on 25-2-2016.
 */
public class Grid {

    public static final int X_WIDTH = 17;
    public static final int Y_LENGTH = 17;

    int lengte;
    int breedte;
    String[][] field;

    public Grid ( int l, int b)
    {

        lengte = l;
        breedte = b;
        field = new String [lengte][breedte];
    }

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
