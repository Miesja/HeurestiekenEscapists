package com.company;

import java.util.*;
public class Options {

    int fieldSize;
    ArrayList<ArrayList<Tile>> options = new ArrayList<>();
    Queue<ArrayList<Tile>> queue = new LinkedList<>();
    //ArrayList<ArrayList<Tile>> archive = new ArrayList<>();


    // The options for the first row should have the biggest tile on the first spot
    public Options(int size, TileCollection collection, Tile biggestTile){
        fieldSize = size;
        ArrayList<Tile> first = new ArrayList<>();
        first.add(biggestTile);
        queue.add(first);
        while(true){
            ArrayList parent = queue.poll();
            if(parent==null){ //queue is empty
                break;
            }
            // archive.add(parent);
            if(checkSum(parent)==fieldSize && parent.contains(biggestTile)){ // possible option
                options.add(parent);
            }
            /*else if(!parent.contains(biggestTile) && checkSum(parent) + biggestTile.width <= fieldSize){
                ArrayList<Tile> child = new ArrayList<>(parent);
                child.add(biggestTile);
            }*/
            else if(checkSum(parent)<fieldSize){
                ArrayList<Tile> possChildren = new ArrayList<>(collection.tiles);
                makeChildren(parent, possChildren);
            }
        }
    }

    // Options for the rest of the rows
    public Options(int size, TileCollection collection){
        fieldSize = size;
        makeStartQueue(collection.tiles);
        while(true){
            ArrayList parent = queue.poll();
            if(parent==null){
                break;
            }
           // archive.add(parent);
            if(checkSum(parent)==fieldSize){
                options.add(parent);
            }
            else if(checkSum(parent)<fieldSize){
                ArrayList<Tile> possChildren = new ArrayList<>(collection.tiles);
                makeChildren(parent, possChildren);
            }
        }
    }

    // make the first arraylists, with one tile each
    private void makeStartQueue(ArrayList list){
        for(int i=0; i<list.size(); i++){
            ArrayList<Tile> element = new ArrayList<>();
            element.add((Tile) list.get(i));
            queue.add(element);
        }
    }

    // return the sum of the tilewidths
    private int checkSum(ArrayList sum){
        int result = 0;
        for(int i=0; i<sum.size(); i++){
            Tile tile = (Tile) sum.get(i);
            result += tile.width;
        }
        return result;
    }

    // create children (adding another tile)
    private void makeChildren(ArrayList parent, ArrayList childrenOptions){
        // remove the tiles that are already in parent from childrenOptions
        for(int i=0; i<parent.size(); i++){
            childrenOptions.remove(parent.get(i));
        }
        for(int i=0; i<childrenOptions.size(); i++){
            ArrayList<Tile> child = new ArrayList<>(parent);
            child.add((Tile) childrenOptions.get(i));
            queue.add(child);
        }
    }

}
