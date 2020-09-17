package com.dooditrol.javasetasks.exceptions;

import java.util.ArrayList;

public class MyArrayList<T> {
    private ArrayList<T> arrayList;

    public MyArrayList() {
        this.arrayList = new ArrayList<T>();
    }

    public void add(T item) throws ExceptionMaxCountElement{

        if (arrayList.size() < 10) {
            arrayList.add(item);
        }
        else {
            throw new ExceptionMaxCountElement("Max elements in list");
        }
    }

}
