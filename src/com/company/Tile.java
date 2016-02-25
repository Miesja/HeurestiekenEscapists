package com.company;

/**
 * Created by Mies on 18/02/16.
 */
/*public class Tile {
    int width;

    public Tile(int width) {
        width = width;
        this.width = width;
    }

    public int width() {
        return width;


        Tile"i"
    }

    public String toString() {
        return "hello";
    }
}*/

    public class Tile{

        int width;
        int length;
        String name;

        public Tile(int width, int length, String name){
            width = width;
            this.width = width;
            length = length;
            this.length = length;
            name = "";
            this.name = name;
            return width;
            return length;
            return name;

        }


        private void makeTile() {
            for (int i = 0; i < 3; i++) {
               Tile tile+i = new Tile (7, 7, name);
                    name = "7T" + i;
            }

            for (int j = 0; j < 3; j++) {
                Tile tile+j = new Tile(5, 5, "5T" + j);
            }
            for (int k = 8; k < 13; k++) {
                Tile tile+k = new Tile(7, 7, "3T" + k);
            }
            Tile tile2 = new Tile(2, 2, "2T");
        }
    }


ptgenerate (i)






