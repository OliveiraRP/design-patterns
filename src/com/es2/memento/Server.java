package com.es2.memento;

import java.util.ArrayList;

public class Server {

    public ArrayList<String> studentNames;

    public Server() {
        studentNames = new ArrayList<>();
    }

    public void addStudent(String studentName) throws ExistingStudentException {

        if(!studentNames.contains(studentName))
            studentNames.add(studentName);
        else
            throw new ExistingStudentException();
    }

    public Memento backup() {

        return new Memento(new ArrayList<>(studentNames));
    }

    public void restore(Memento state) {

        studentNames = state.getState();
    }

    public ArrayList<String> getStudentNames() {

        return this.studentNames;
    }
}
