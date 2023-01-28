package com.sharunkumar;

public class FindHouses {

    public static int houses_solution(String[] board) {
        int result = 0;
        int[][] visited = new int[board.length][board[0].length()];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                if (visited[i][j] == 0) {
                    visited[i][j] = 1;
                    char ch = board[i].charAt(j);

                    if (ch == '1') {
                        int house = find_house(board, i, j, visited);
                        if (house > 0) {
                            result++;
                        }
                    }
                }
            }
        }

        return result;
    }

    private static int find_house(String[] board, int i, int j, int[][] visited) {
        int house_size = 1;
        visited[i][j] = 1;

        while (board[i].charAt(j) == '1') {
            char ch_top = safe_get(board, i - 1, j, visited);
            char ch_bottom = safe_get(board, i + 1, j, visited);
            char ch_left = safe_get(board, i, j - 1, visited);
            char ch_right = safe_get(board, i, j + 1, visited);

            if (ch_top != '1' && ch_bottom != '1' && ch_left != '1' && ch_right != '1') {
                break;
            }

            if (ch_top == '1') {
                house_size += find_house(board, i - 1, j, visited);
            }
            if (ch_bottom == '1') {
                house_size += find_house(board, i + 1, j, visited);
            }
            if (ch_left == '1') {
                house_size += find_house(board, i, j - 1, visited);
            }
            if (ch_right == '1') {
                house_size += find_house(board, i, j + 1, visited);
            }
        }

        return house_size;
    }

    private static char safe_get(String[] board, int i, int j, int[][] visited) {
        try {
            if (visited[i][j] == 1) {
                return '0';
            }
            return board[i].charAt(j);
        } catch (Exception e) {
            return '0';
        }
    }

    public static void main(String[] args) {

        String[] board = new String[]{
                "00000",
                "01100",
                "00110",
                "00000",
                "01100",
        };

        int result = houses_solution(board);

        System.out.println(result);
    }
}