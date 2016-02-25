package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Manon Schriever on 23-02-16.
 */
public class RowOptionsGenerator {
    static ArrayList<Integer> tileWidths = new ArrayList<>();
    static int fieldSize = 17;
    ArrayList<ArrayList<Integer>> options = new ArrayList<>();
    Queue<ArrayList<Integer>> queue = new LinkedList<>();
    ArrayList<ArrayList<Integer>> archive = new ArrayList<>();

    public void run() {
        
        makeOptions();
        System.out.println(options);
    }

    private void makeOptions(){
        makeStartQueue(tileWidths);
        while(true){
            ArrayList parent = queue.poll();
            if(parent==null){
                break;
            }
            archive.add(parent);
            if(checkSum(parent)==fieldSize){
                if(!checkDuplicates(parent, options)) {
                    options.add(parent);
                }
            }
            else if(checkSum(parent)<fieldSize){
                ArrayList<Integer> possChildren = new ArrayList<>(tileWidths);
                makeChildren(parent, possChildren);
            }
        }
    }

    private void makeStartQueue(ArrayList list){
        for(int i=0; i<list.size(); i++){
            ArrayList<Integer> element = new ArrayList<>();
            element.add((Integer) list.get(i));
            if(!checkDuplicates(element, queue)){
                queue.add(element);
            }
        }
    }

    private int checkSum(ArrayList sum){
        int result = 0;
        for(int i=0; i<sum.size(); i++){
            result += (int) sum.get(i);
        }
        return result;
    }


    private void makeChildren(ArrayList parent, ArrayList childrenOptions){
        for(int i=0; i<parent.size(); i++){
            childrenOptions.remove(parent.get(i));
        }
        for(int i=0; i<childrenOptions.size(); i++){
            ArrayList<Integer> child = new ArrayList<>(parent);
            child.add((Integer) childrenOptions.get(i));
            if(!checkDuplicates(child, archive) && !checkDuplicates(child, queue)){
                queue.add(child);
            }
        }
    }

    private boolean checkDuplicates(ArrayList element, ArrayList list){
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
    }
}
