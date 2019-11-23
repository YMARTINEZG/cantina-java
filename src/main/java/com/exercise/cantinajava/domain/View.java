package com.exercise.cantinajava.domain;


import java.util.ArrayList;
import java.util.List;

public class View implements AbstractView{
    private String classView;
    private List<String> classNames;
    private String identifier;

    public View() {
        this.classNames = new ArrayList<>();
    }

    public View(String classView) {
        this.classView = classView;
    }

    public View(String classView, List<String> classNames) {
        this.classView = classView;
        this.classNames = classNames;
    }

    public View(String classView, String classNames,String identifier) {
        this.classView = classView;
        this.classNames = new ArrayList<>();
        this.identifier = identifier;
    }

    @Override
    public int count(String selector) {
        if(classView.equals(selector)){
            return 1;
        }
        return 0;
    }

    public void setClassView(String classView) {
        this.classView = classView;
    }

    public void addClassName(String className) {
        this.classNames.add(className);
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

}
