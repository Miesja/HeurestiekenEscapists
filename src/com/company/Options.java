package com.company;

import java.util.*;
public class Options {

    int fieldSize;
    ArrayList<ArrayList<Tile>> options = new ArrayList<>();
    Queue<ArrayList<Tile>> queue = new LinkedList<>();
    ArrayList<ArrayList<Tile>> archive = new ArrayList<>();

    public Options(Grid grid) {
        fieldSize = grid.breedte;
    }

    public void makeOptions(TileCollection collection){
        makeStartQueue(collection.tiles);
        while(true){
            ArrayList parent = queue.poll();
            if(parent==null){
                break;
            }
            archive.add(parent);
            if(checkSum(parent)==fieldSize){
                options.add(parent);
             // proberen om de dubbele combi opties eruit te halen om de initiele fieldstack te verkleinen.
             /*   for(int i=0; i<options.size(); i++){
                    if(parent.size() == options.get(i).size()) {
                        for (int j=0; j<parent.size(); j++){
                            if(options.get(i).contains(parent.get(j))){
                                options.add(parent);
                            }
                        }
                    }else{
                        options.add(parent);
                    }
                }
             */
            }
            else if(checkSum(parent)<fieldSize){
                ArrayList<Tile> possChildren = new ArrayList<>(collection.tiles);
                makeChildren(parent, possChildren);
            }
        }
    }

    private void makeStartQueue(ArrayList list){
        for(int i=0; i<list.size(); i++){
            ArrayList<Tile> element = new ArrayList<>();
            element.add((Tile) list.get(i));
            queue.add(element);
        }
    }

    private int checkSum(ArrayList sum){
        int result = 0;
        for(int i=0; i<sum.size(); i++){
            Tile tile = (Tile) sum.get(i);
            result += tile.width;
        }
        return result;
    }

    private void makeChildren(ArrayList parent, ArrayList childrenOptions){
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
