package com.dooditrol.javasetasks.collections;

import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class TestOfList {
    private static Random rand = new Random();
    private static long start, end;

    public static long testTimeOfAdd(List<Integer> list) {
        start = System.nanoTime();

        for (int i = 0; i < 0.1 * list.size(); i++) {
            list.add(rand.nextInt(list.size()), 5);
        }
        end = System.nanoTime();
        return end - start;
    }

    public static long testTimeOfRemove(List<Integer> list) {
        start = System.nanoTime();

        for (int i = 0; i < 0.1 * list.size(); i++) {
            list.remove(rand.nextInt(list.size()));
        }
        end = System.nanoTime();
        return end - start;
    }

    public static long testTimeOfGet(List<Integer> list) {
        start = System.nanoTime();

        for (int i = 0; i < 0.1 * list.size(); i++) {
            list.get(rand.nextInt(list.size()));
        }
        end = System.nanoTime();
        return end - start;
    }

    public static long testTimeOfAddByIterator(List<Integer> list) {
        int half = list.size() / 2;
        ListIterator<Integer> it = list.listIterator(half);
        start = System.nanoTime();

        for (int i = 0; i < 0.1 * list.size(); i++) {
            it.add(47);
        }
        end = System.nanoTime();
        return end - start;
    }

    public static long testTimeOfRemoveByIterator(List<Integer> list) {
        int half = list.size() / 2;
        ListIterator<Integer> it = list.listIterator(half);
        start = System.nanoTime();

        for (int i = 0; i < 0.1 * list.size(); i++) {
            it.next();
            it.remove();
        }
        end = System.nanoTime();
        return end - start;
    }
}
