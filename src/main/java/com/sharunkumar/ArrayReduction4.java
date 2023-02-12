package com.sharunkumar;

import java.util.ArrayList;
import java.util.List;


/// FIXME: Work in Progress
class Pair {
    public int k;
    public int mex;

    public Pair(int k, int mex) {
        this.k = k;
        this.mex = mex;
    }
}

public class ArrayReduction4 {

    private static int mex(List<Integer> a) {
        int i = 0;
        while (a.contains(i)) {
            i++;
        }
        return i;
    }

    private static boolean lex_compare(List<Integer> a, List<Integer> b) {
        int i = 0;
        while (i < a.size() && i < b.size()) {
            if (a.get(i) > b.get(i)) {
                return true;
            } else if (a.get(i) < b.get(i)) {
                return false;
            }
            i++;
        }
        return a.size() > b.size();
    }

    public static Pair find_best_mex(List<Integer> arr) {
        int best_k = 0;
        int best_mex = mex(arr);
        for (int k = 1; k < arr.size(); k++) {
            var subArray = arr.subList(0, k);
            int mex = mex(subArray);
            if (mex > best_mex) {
                best_mex = mex;
                best_k = k;
            } else if (mex == best_mex) {
                var bestSubArray = arr.subList(0, best_k);
                if (lex_compare(subArray, bestSubArray)) {
                    best_mex = mex;
                    best_k = k;
                }
            }
        }
        return new Pair(best_k, best_mex);
    }

    public static List<Integer> getMaxArray(List<Integer> arr) {

        List<Integer> result = new ArrayList<>();

        while(arr.size() > 1) {
            Pair best = find_best_mex(arr);
            result.add(best.mex);
            arr = arr.subList(best.k, arr.size());
        }

        result.add(mex(arr));

        return result;
    }


    public static void main(String[] args) {
        System.out.println(getMaxArray(List.of(2, 2, 3, 4, 0, 1, 2, 0)));
        System.out.println(getMaxArray(List.of(0,1,1,0)));
    }
}
