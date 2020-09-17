package com.dooditrol.javasetasks.collections;

import java.util.*;

public class TestOfCollections {

    private static final int LOW = 100;
    private static final int MEDIUM = 10000;
    private static final int HIGH = 1000000;

    public static void main(String[] args) {
        int size = MEDIUM;
        Integer[] data = createArrayInteger(size);

        System.out.println("Test of lists." + size + " elements" + "\n----------------");
        System.out.println("random access");
        List<Integer> list = new ArrayList<Integer>();
        testOfListRandomAccess(list, data);
        list = new LinkedList<Integer>();
        testOfListRandomAccess(list, data);

        System.out.println("\naccess by iterator");
        list = new ArrayList<Integer>();
        testOfListIterator(list, data);
        list = new LinkedList<Integer>();
        testOfListIterator(list, data);

        System.out.println("\n\nTest of sets." + size + " elements" + "\n----------------");
        Set<Integer> set = new TreeSet<Integer>();
        testOfSet(set, data);
        set = new HashSet<Integer>();
        testOfSet(set, data);
    }

    private static Integer[] createArrayInteger(int size) {
        Integer[] array = new Integer[size];

        for (int i = 0; i < size; i++) {
            array[i] = i;
        }

        return array;
    }

    private static void testOfListRandomAccess(List<Integer> list, Integer[] data) {
        Collections.addAll(list, data);
        System.out.println(list.getClass() + " test");
        System.out.println("Add 10% element - " +
                String.format("%,12d", TestOfList.testTimeOfAdd(list)) +  " ns");
        System.out.println("Remove 10% element - " +
                String.format("%,12d", TestOfList.testTimeOfRemove(list)) +  " ns");
        System.out.println("Search 10% element - " +
                String.format("%,12d", TestOfList.testTimeOfGet(list)) +  " ns");
    }

    private static void testOfListIterator(List<Integer> list, Integer[] data) {
        Collections.addAll(list, data);
        System.out.println(list.getClass() + " test");
        System.out.println("Add 10% element - " +
                String.format("%,12d", TestOfList.testTimeOfAddByIterator(list)) +  " ns");
        System.out.println("Remove 10% element - " +
                String.format("%,12d", TestOfList.testTimeOfRemoveByIterator(list)) +  " ns");
    }

    private static void testOfSet(Set<Integer> set, Integer[] data) {
        Collections.addAll(set, data);
        System.out.println(set.getClass() + " test");
        System.out.println("Add 10% element - " +
                String.format("%,12d", TestOfSet.testTimeOfAdd(set)) + " ns");
        System.out.println("Remove 10% element - " +
                String.format("%,12d", TestOfSet.testTimeOfRemove(set)) + " ns");
        System.out.println("Contains 10% element - " +
                String.format("%,12d", TestOfSet.testTimeOfContains(set)) + " ns");
    }
}
