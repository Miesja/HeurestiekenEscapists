package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Manon Schriever on 23-02-16.
 */
public class options {
    static ArrayList<Tile> tiles = new ArrayList<>();
    static int fieldSize = 17;
    ArrayList<ArrayList<Tile>> options = new ArrayList<>();
    Queue<ArrayList<Tile>> queue = new LinkedList<>();
    ArrayList<ArrayList<Tile>> archive = new ArrayList<>();

    public void run() {
        makeOptions();
        for(int i=0; i<options.size(); i++){
            System.out.print("[");
            for(int j=0; j<options.get(i).size(); j++){
                System.out.print(options.get(i).get(j).width + ", ");
            }
            System.out.print("], ");
        }
    }

    private void makeOptions(){
        makeStartQueue(tiles);
        while(true){
            ArrayList parent = queue.poll();
            if(parent==null){
                break;
            }
            archive.add(parent);
            if(checkSum(parent)==fieldSize){
              //  if(!checkDuplicates(parent, options)) {
                    options.add(parent);
              //  }
            }
            else if(checkSum(parent)<fieldSize){
                ArrayList<Tile> possChildren = new ArrayList<>(tiles);
                makeChildren(parent, possChildren);
            }
        }
    }

    private void makeStartQueue(ArrayList list){
        for(int i=0; i<list.size(); i++){
            ArrayList<Tile> element = new ArrayList<>();
            element.add((Tile) list.get(i));
            //if(!checkDuplicates(element, queue)){
                queue.add(element);
           // }
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
           // if(!checkDuplicates(child, archive) && !checkDuplicates(child, queue)){
                queue.add(child);
            //}
        }
    }

   /* private boolean checkDuplicates(ArrayList element, ArrayList list){
        if(list.contains(element)){
            return true;
        }
        return false;
    }

    private boolean checkDuplicates(ArrayList element, Queue list){
        if(list.contains(element)){
            return true;
        }
        return false;
    }*/
}
