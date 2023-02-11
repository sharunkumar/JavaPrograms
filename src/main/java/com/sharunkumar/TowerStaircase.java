package com.sharunkumar;

public class TowerStaircase {
    public static int minMoves(int[] towers) {
        int min_moves = find_moves_around(towers, 0, Integer.MAX_VALUE);
        for (int i = 1; i < towers.length - 1; i++) {
            min_moves = Math.min(min_moves, find_moves_around(towers, i, min_moves));
        }
        return min_moves;
    }

    private static int find_moves_around(int[] towers, int pivot, int breakpoint) {
        int steps_downwards = 0;
        int steps_upwards = 0;

        for (int i = 0; i < towers.length - 1; i++) {
            int expected_height_for_downwards = towers[pivot] - (pivot - i);
            int expected_height_for_upwards = towers[pivot] + (pivot - i);

            steps_upwards += Math.abs(towers[i] - expected_height_for_upwards);
            steps_downwards += Math.abs(towers[i] - expected_height_for_downwards);

            if(steps_upwards > breakpoint && steps_downwards > breakpoint) return breakpoint;
        }

        return Math.min(steps_downwards, steps_upwards);
    }

    public static void main(String[] args) {
        int[] towers = {5, 7, 9, 4, 11};
        System.out.println(minMoves(towers)); // Output: 9
        // final array: [7,8,9,10,11]
    }

}
