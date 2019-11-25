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
    public void ls(List<View> list,String typeSelector, String selectorValue) {
        this.selectView(list, typeSelector, selectorValue, this);
    }

    @Override
    public int count(String selector) {
        if(classView.equals(selector)){
            return 1;
        }
        return 0;
    }
    public String getClassView() {return classView; }
    public List<String> getClassNames() {
        return classNames;
    }
    public String getIdentifier() {
        return identifier;
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
    protected void selectView(List<View> list,String typeSelector, String selectorValue, View view){
        switch (typeSelector) {
            case "classView":
                if(view.getClassView().equals(selectorValue)){
                    list.add(view);
                }
                break;
            case "identifier":
                if(view.getIdentifier() != null && view.getIdentifier().equals(selectorValue)){
                    list.add(view);
                }
                break;
            case "classNames":
                if(view.getClassNames() != null && view.getClassNames().size() > 0) {
                    view.getClassNames().forEach(str -> {
                        if(str.equals(selectorValue)) {
                            list.add(view);
                        }
                    });
                }
                break;
            default:
                break;
        }
    }

    @Override
    public String toString() {
        return "View{" +
                "classView='" + classView + '\'' +
                ", classNames=" + classNames +
                ", identifier='" + identifier + '\'' +
                '}';
    }
}
