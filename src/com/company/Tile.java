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
            this.width = width;
            this.length = length;
            //name = "";
            this.name = name;

        }

        public void setTile(int x, int y) {
            System.out.println(name);
            System.out.println(width);


        }

    }








