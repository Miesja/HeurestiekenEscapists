package com.company;

import java.util.ArrayList;

/**
 * Created by Mies on 17/02/16.
 */
public class HetVeld {
    
    public static final int X_WIDTH = 17;
    public static final int Y_LENGTH = 17;

    public String[][] Field;
    public ArrayList<ArrayList<String>> ListField;


    //2D Array veld
    public void ArrayField () {
        Field = new String[X_WIDTH][Y_LENGTH];
    }


    // 2D ArrayList veld
    public void ListField() {
        ListField = new ArrayList<ArrayList<String>>();

        for (x = 0; x < X_WIDTH; x++) {
            ArrayList<String> FieldLength = new ArrayList<String>();
            ListField(i, FieldLength);

            for (y = 0; y < Y_LENGTH; y++) {
                String FieldValue = "null";
                FieldLength.add(y, FieldValue);
            }
        }

    }



}
