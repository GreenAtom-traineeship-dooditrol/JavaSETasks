package com.dooditrol.javasetasks.collections;

import java.util.HashMap;
import java.util.Map;

public class MapTask {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("Cat", 5);
        map.put("dog", 7);
        map.put("snake", 10);
        map.put("tree", 10);

        System.out.println("map: " + map);

        Map<Integer, String> reverseMap = new HashMap<Integer, String>();

        for (Map.Entry<String, Integer> item : map.entrySet()) {
            reverseMap.put(item.getValue(), item.getKey());
        }
        System.out.println("reverse map: " + reverseMap);
    }
}
