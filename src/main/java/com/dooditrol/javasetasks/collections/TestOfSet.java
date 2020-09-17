package com.dooditrol.javasetasks.collections;

import java.util.Set;
import java.util.Random;

public class TestOfSet {
    private static Random rand = new Random();
    private static long start, end;

    public static long testTimeOfAdd(Set<Integer> set) {
        start = System.nanoTime();

        for (int i = 0; i < 0.1 * set.size(); i++) {
            set.add(set.size() + i);
        }
        end = System.nanoTime();
        return end - start;
    }

    public static long testTimeOfRemove(Set<Integer> set) {
        start = System.nanoTime();

        for (int i = 0; i < 0.1 * set.size(); i++) {
            set.remove(set.size() - i - 1);
        }
        end = System.nanoTime();
        return end - start;
    }

    public static long testTimeOfContains(Set<Integer> set) {
        start = System.nanoTime();

        for (int i = 0; i < 0.1 * set.size(); i++) {
            set.contains(i);
        }
        end = System.nanoTime();
        return end - start;
    }
}
