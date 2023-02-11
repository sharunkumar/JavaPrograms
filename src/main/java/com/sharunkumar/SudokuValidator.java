package com.sharunkumar;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;

public class SudokuValidator {

    private static boolean boardIterator(int[][] board, BiFunction<Integer, Integer, Boolean> func) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!func.apply(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static  boolean isValidSudokuNumber(int n) {
        return n >= 1 && n <= 9;
    }

    public static boolean isValidSudoku(int[][] board) {
        // Check each row for duplicates
        HashMap<Integer, Set<Integer>> rowMap = new HashMap<>();
        if(!boardIterator(board, (i, j) -> rowMap.computeIfAbsent(i, k -> new HashSet<>()).add(board[i][j]))) {
            return false;
        };

        // Check each column for duplicates
        HashMap<Integer, Set<Integer>> colMap = new HashMap<>();
        if(!boardIterator(board, (i, j) -> colMap.computeIfAbsent(j, k -> new HashSet<>()).add(board[i][j]))) {
            return false;
        };

        // Check each 3x3 subgrid for duplicates
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                HashSet<Integer> subgrid = new HashSet<>();
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        if (board[k][l] != 0 && !subgrid.add(board[k][l])) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] board = {{5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}};

        System.out.println(isValidSudoku(board));
    }

}
