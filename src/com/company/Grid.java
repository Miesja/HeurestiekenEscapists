package com.company;

/**
 * Created by Bas on 25-2-2016.
 */
public class Grid {

    public static final int X_WIDTH = 17;
    public static final int Y_LENGTH = 17;

    public Grid ( int lengte, int breedte)
    {
        lengte = this.lengte;
        breedte = this.breedte;
    }

    Field = new String[X_WIDTH][Y_LENGTH];
}
    public void printVeld()
    {
        for( int i = 0; i < X_WIDTH; i++ )
        {
            String Row = "";
            for( int j = 0; j < Y_LENGTH; j++)
            {
                String A = veld.Field[ i ][ j ];
                Row += A;
            }
            System.out.println( Row );
        }
    }
}
