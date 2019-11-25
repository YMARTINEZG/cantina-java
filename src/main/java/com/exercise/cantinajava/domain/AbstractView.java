package com.exercise.cantinajava.domain;


import java.util.List;

public interface AbstractView {
    void ls(List<View> list, String typeSelector, String selectorValue);
    int count(String selector);
}
