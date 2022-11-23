package com.streetcats.data;

import com.streetcats.model.Cat;

import java.util.ArrayList;

public class Datasource {

    public ArrayList<Cat> loadNames() {
        ArrayList<Cat> names = new ArrayList<>();
        for (int i=0; i<10; i++) {
            names.add(new Cat("Cat " + (i+1)));
        }
        return names;
    }
}
