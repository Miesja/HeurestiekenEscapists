package com.company;

/**
 * Created by Bas on 25-2-2016.
 */
public class Grid {

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
