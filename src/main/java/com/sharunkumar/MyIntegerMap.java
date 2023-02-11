package com.sharunkumar;

import java.util.HashMap;
import java.util.Map;

public class MyIntegerMap {
    private final Map<Integer, Integer> innerMap;
    private int key_diff = 0;
    private int value_diff = 0;

    public MyIntegerMap() {
        innerMap = new HashMap<>();
    }

    public Integer get(int key) {
        var keyWithoutOffset = key - key_diff;
        var value = innerMap.get(keyWithoutOffset);
        if (value == null) return null;
        return value + value_diff;
    }

    public void put(int key, int value) {
        var keyWithoutOffset = key - key_diff;
        var valueWithoutOffset = value - value_diff;
        innerMap.put(keyWithoutOffset, valueWithoutOffset);
    }

    public void addToValues(int toAdd) {
        this.value_diff += toAdd;
    }

    public void addToKeys(int toAdd) {
        this.key_diff += toAdd;
    }

    static long solution(String[] queryType, int[][] query) {
        long sum = 0;
        var map = new MyIntegerMap();
        for (int i = 0; i < queryType.length; i++) {
            String currQuery = queryType[i];
            switch (currQuery) {
                case "insert" -> map.put(query[i][0], query[i][1]);
                case "addToValue" -> map.addToValues(query[i][0]);
                case "addToKey" -> map.addToKeys(query[i][0]);
                case "get" -> sum += map.get(query[i][0]);
            }
        }
        return sum;
    }
}
