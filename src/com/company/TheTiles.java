package com.company;

/**
 * Created by Mies on 17/02/16.
 */
/*
public class TheTiles {
    public static final int X_TILE_7A = 7;
    public static final int Y_TILE_7A = 7;
    public static final int X_TILE_7B = 7;
    public static final int Y_TILE_7B = 7;
    public static final int X_TILE_7C = 7;
    public static final int Y_TILE_7C = 7;
    public static final int X_TILE_5A = 5;
    public static final int Y_TILE_5A = 5;
    public static final int X_TILE_5B = 5;
    public static final int Y_TILE_5B = 5;
    public static final int X_TILE_5C = 5;
    public static final int Y_TILE_5C = 5;
    public static final int X_TILE_3A = 3;
    public static final int Y_TILE_3A = 3;
    public static final int X_TILE_3B = 3;
    public static final int Y_TILE_3B = 3;
    public static final int X_TILE_3C = 3;
    public static final int Y_TILE_3C = 3;
    public static final int X_TILE_3D = 3;
    public static final int Y_TILE_3D = 3;
    public static final int X_TILE_3E = 3;
    public static final int Y_TILE_3E = 3;
    public static final int X_TILE_3F = 3;
    public static final int Y_TILE_3F = 3;
    public static final int X_TILE_3G = 3;
    public static final int Y_TILE_3G = 3;
    public static final int X_TILE_2A = 2;
    public static final int Y_TILE_2A = 2;

    public String [][] Tile7A;
    public String [][] Tile7B;
    public String [][] Tile7C;
    public String [][] Tile5A;
    public String [][] Tile5B;
    public String [][] Tile5C;
    public String [][] Tile3A;
    public String [][] Tile3B;
    public String [][] Tile3C;
    public String [][] Tile3D;
    public String [][] Tile3E;
    public String [][] Tile3F;
    public String [][] Tile3G;
    public String [][] Tile2A;

    private void Tegels () {

        Tile7A = new String[X_TILE_7A][Y_TILE_7A];
        for (int i = 0; i < X_TILE_7A; i++) {
            for (int j = 0; j < Y_TILE_7A; j++) {
                Tile7A[i][j] = "7a";
            }
        }
        Tile7B = new String[X_TILE_7B][Y_TILE_7B];
        for (int i = 0; i < X_TILE_7B; i++) {
            for (int j = 0; j < Y_TILE_7B; j++) {
                Tile7B[i][j] = "7b";
            }
        }
        Tile7C = new String[X_TILE_7C][Y_TILE_7C];
        for (int i = 0; i < X_TILE_7C; i++) {
            for (int j = 0; j < Y_TILE_7C; j++) {
                Tile7C[i][j] = "7c";
            }
        }

        Tile5A = new String[X_TILE_5A][Y_TILE_5A];
        for (int i = 0; i < X_TILE_5A; i++) {
            for (int j = 0; j < Y_TILE_5A; j++) {
                Tile5A[i][j] = "5a";
            }
        }
        Tile5B = new String[X_TILE_5B][Y_TILE_5B];
        for (int i = 0; i < X_TILE_5B; i++) {
            for (int j = 0; j < Y_TILE_5B; j++) {
                Tile5B[i][j] = "5b";
            }
        }
        Tile5C = new String[X_TILE_5C][Y_TILE_5C];
        for (int i = 0; i < X_TILE_5C; i++) {
            for (int j = 0; j < Y_TILE_5C; j++) {
                Tile5C[i][j] = "5c";
            }
        }

        Tile3A = new String[X_TILE_3A][Y_TILE_3A];
        for (int i = 0; i < X_TILE_3A; i++) {
            for (int j = 0; j < Y_TILE_3A; j++) {
                Tile3A[i][j] = "3a";
            }
        }
        Tile3B = new String[X_TILE_3B][Y_TILE_3B];
        for (int i = 0; i < X_TILE_3B; i++) {
            for (int j = 0; j < Y_TILE_3B; j++) {
                Tile3B[i][j] = "3b";
            }
        }
        Tile3C = new String[X_TILE_3C][Y_TILE_3C];
        for (int i = 0; i < X_TILE_3C; i++) {
            for (int j = 0; j < Y_TILE_3C; j++) {
                Tile3C[i][j] = "3c";
            }
        }
        Tile3D = new String[X_TILE_3D][Y_TILE_3D];
        for (int i = 0; i < X_TILE_3A; i++) {
            for (int j = 0; j < Y_TILE_3D; j++) {
                Tile3D[i][j] = "3d";
            }
        }
        Tile3E = new String[X_TILE_3E][Y_TILE_3E];
        for (int i = 0; i < X_TILE_3E; i++) {
            for (int j = 0; j < Y_TILE_3E; j++) {
                Tile3E[i][j] = "3e";
            }
        }
        Tile3F = new String[X_TILE_3F][Y_TILE_3F];
        for (int i = 0; i < X_TILE_3F; i++) {
            for (int j = 0; j < Y_TILE_3F; j++) {
                Tile3F[i][j] = "3f";
            }
        }
        Tile3G = new String[X_TILE_3G][Y_TILE_3G];
        for (int i = 0; i < X_TILE_3G; i++) {
            for (int j = 0; j < Y_TILE_3G; j++) {
                Tile3G[i][j] = "3e";
            }
        }
        Tile2A = new String[X_TILE_2A][Y_TILE_2A];
        for (int i = 0; i < X_TILE_2A; i++) {
            for (int j = 0; j < Y_TILE_2A - 1; j++) {
                Tile2A[i][j] = "2a";
            }
        }
    }
    /*
    public int [] Tile7a;
    Tile7a = new int[2]
    Tile7a[0] = X_TILE_7A
    Tile7a[1] = Y_TILE_7A
    */



//}
