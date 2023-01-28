package com.sharunkumar;

import java.util.HashMap;
import java.util.Map;

public class PlaneDeliveringFood {

    public static int maxAlignedPoints(int[] xCoords, int[] yCoords) {
        Map<Integer, Integer> xAlign = new HashMap<>();
        Map<Integer, Integer> yAlign = new HashMap<>();

        for (int i = 0; i < xCoords.length; i++) {
            xAlign.put(xCoords[i], xAlign.getOrDefault(xCoords[i], 0) + 1);
            yAlign.put(yCoords[i], yAlign.getOrDefault(yCoords[i], 0) + 1);
        }
        int maxAligned = 0;
        for (Integer count : xAlign.values()) {
            maxAligned = Math.max(maxAligned, count);
        }
        for (Integer count : yAlign.values()) {
            maxAligned = Math.max(maxAligned, count);
        }
        return maxAligned;
    }

    public static void main(String[] args) {
        int[] xCoords = {2,3,2,4,2};
        int[] yCoords = {2,2,6,5,8};
        System.out.println(maxAlignedPoints(xCoords, yCoords));
    }
}

