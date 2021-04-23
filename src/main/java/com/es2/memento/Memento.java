package com.es2.memento;

import java.util.ArrayList;

public class Memento {

    ArrayList<String> state;

    public Memento(ArrayList<String> studentNames) {

        state = studentNames;
    }

    public ArrayList<String> getState() {

        return state;
    }
}
