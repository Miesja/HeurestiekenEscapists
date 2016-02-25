package com.company;

/**
 * Created by Bas on 25-2-2016.
 */

public class Grid {

    int lengte;
    int breedte;


    public Grid ( int l, int b)
    {
        lengte = l;
        breedte = b;
    }

    public void maakVeld()
    {
        for( int i = 0; i < lengte; i++ )
        {
            String Row = "";
            for( int j = 0; j < breedte; j++)
            {
               // String A = TheField.Field[ i ][ j ];
               // Row += A;
            }
            System.out.println( Row );
        }
    }
}
