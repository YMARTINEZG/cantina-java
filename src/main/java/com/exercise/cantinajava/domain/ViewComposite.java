package com.exercise.cantinajava.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ViewComposite extends View{
    private List<View> views = new ArrayList<>();
    public ViewComposite() {
        this.views = new ArrayList<>();
    }

    public ViewComposite(String classView, String className, String identifier) {
        super(classView, className, identifier);
    }

    public void add(View view){
        this.views.add(view);
    }
    @Override
    public void ls(List<View> list,String typeSelector, String selectorValue ) {
        selectView(list, typeSelector, selectorValue, this);
        this.views.forEach(view -> view.ls(list, typeSelector, selectorValue));
    }
    @Override
    public int count(String selector) {
        int conval = 0;
        if(this.getClassView().equals(selector)){
           conval++;
        }
        Iterator<View> iter = views.iterator();
        while(iter.hasNext()){
            View obj = iter.next();
            conval += obj.count(selector);
        }
        return conval;
    }

    @Override
    public String toString() {
        return "ViewComposite{" +
                super.toString() +
                "views=" + views +
                '}';
    }
}
