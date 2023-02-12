package com.sharunkumar;

import java.util.*;

/// FIXME: Work in Progress

class Task {
    int cost;
    int time;
}

public class TaskScheduling {
    public static int solve(List<Integer> costs, List<Integer> times) {
        List<Task> tasks = new ArrayList<>();
        for (int i = 0 ; i < costs.size() ; ++i) {
            Task t = new Task();
            t.cost = costs.get(i);
            t.time = times.get(i);
            tasks.add(t);
        }

        tasks.sort((t1, t2) -> {
            if (t1.cost == t2.cost) {
                return t2.time - t1.time;
            }
            return t1.cost - t2.cost;
        });

        int i = 0;
        int j = tasks.size() - 1;
        int totalCost = 0;
        if (i == j && i == 0) {
            return tasks.get(0).cost;
        }
        while (i < j) {
            totalCost += tasks.get(i).cost;
            int p = tasks.get(i).time;
            while (p-- > 0 && i < j) {
                j--;
            }
            i++;
        }
        return totalCost;
    }

    public static void main(String[] args) {
        System.out.println(solve(Arrays.asList(1,1,3,4), Arrays.asList(3,1,2,3)));
        System.out.println(solve(Arrays.asList(1,2,3,2), Arrays.asList(1,2,3,2)));
        System.out.println(solve(Arrays.asList(2,3,4,2), Arrays.asList(1,1,1,1)));
        System.out.println(solve(List.of(4), List.of(2)));
    }
}

