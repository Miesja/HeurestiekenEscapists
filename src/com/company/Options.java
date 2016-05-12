package com.company;

import java.util.*;
public class Options {

    boolean draaibaar;
    int fieldSize;
    HashSet<ArrayList<Tile>> options = new HashSet<>();
    Queue<ArrayList<Tile>> queue = new LinkedList<>();
    //ArrayList<ArrayList<Tile>> archive = new ArrayList<>();


    // The options for the first row should have the biggest tile on the first spot
    public Options(int size, TileCollection collection, Tile biggestTile, boolean draai){
        draaibaar = draai;
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
    public Options(int size, TileCollection collection, boolean draai){
        draaibaar = draai;
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
    private void makeChildren(ArrayList<Tile> parent, ArrayList<Tile> childrenOptions){


        // ARCHIVE: gebruikt voor het maken zonder permutaties
        /*int x = 0;
        while(x<childrenOptions.size() && childrenOptions.get(x)!=parent.get(0)){
            childrenOptions.remove(x);
            x++;
        }*/

        // remove the tiles that are already in parent from childrenOptions
        for(Tile tile : parent){
            if(draaibaar) {
            int index = childrenOptions.indexOf(tile);

                if (tile.turned) {
                    childrenOptions.remove(index);
                    childrenOptions.remove(index - 1);
                } else {
                    childrenOptions.remove(index + 1);
                    childrenOptions.remove(index);
                }
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
