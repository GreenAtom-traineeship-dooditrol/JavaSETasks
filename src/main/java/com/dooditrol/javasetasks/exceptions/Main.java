package com.dooditrol.javasetasks.exceptions;

public class Main {

    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<Integer>();

        for (int i = 0; i < 11; i++) {
            try {
                list.add(i);
            } catch (ExceptionMaxCountElement ex) {
                System.out.println(ex.getMessage());
                System.out.println(ex);
                ex.printStackTrace();
            }
        }
    }
}
