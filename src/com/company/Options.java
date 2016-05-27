package com.company;

import com.sun.management.GarbageCollectionNotificationInfo;

import java.util.*;
public class Options {

    boolean turnable;
    int fieldSize;
    HashSet<ArrayList<Tile>> options = new HashSet<>();
    Queue<ArrayList<Tile>> queue = new LinkedList<>();

    public void makeOptions(ArrayList<Tile> collection){
        while(true){
            ArrayList<Tile> parent = queue.poll();
            // Stop when the queue is empty
            if(parent==null){
                break;
            }
            if(checkSum(parent)==fieldSize){ // The current list is an option
                options.add(parent);
            }
            else if(checkSum(parent)<fieldSize){
                ArrayList<Tile> possChildren = new ArrayList<>(collection);
                makeChildren(parent, possChildren);
            }
        }

    }

    // The options for the first row should have the biggest tile on the first spot
    public Options(int size, ArrayList<Tile> collection, Tile biggestTile, boolean turn){
        turnable = turn;
        fieldSize = size;
        ArrayList<Tile> first = new ArrayList<>();
        first.add(biggestTile);
        queue.add(first);
        makeOptions(collection);

    }

    // Options for the rest of the rows
    public Options(int size, ArrayList<Tile> collection, boolean turn){
        turnable = turn;
        fieldSize = size;
        makeStartQueue(collection);
        makeOptions(collection);
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
    private void makeChildren(ArrayList<Tile> parent, ArrayList<Tile> childrenOptions){

        // removes the tiles that are already in parent from childrenOptions
        for(Tile tile : parent){
            if(turnable) {
                childrenOptions.remove(tile);
                Tile turned = tile.turnTile();
                childrenOptions.remove(turned);
            }
            else{
                childrenOptions.remove(tile);
            }
        }

        for(int i=0; i<childrenOptions.size(); i++){
            ArrayList<Tile> child = new ArrayList<>(parent);
            child.add(childrenOptions.get(i));
            queue.add(child);
        }
    }

}
