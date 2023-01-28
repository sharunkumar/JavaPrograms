package org.example;

public class Main {

    public static int[] warships_solution(String[] board) {
        int[] result = new int[3];
        int[][] visited = new int[board.length][board[0].length()];

        for(int i = 0; i< board.length; i++) {
            for(int j = 0; j< board[i].length(); j++) {
                if(visited[i][j] == 0) {
                    visited[i][j] = 1;
                    char ch = board[i].charAt(j);

                    if(ch == '#') {
                        int ship = find_ship(board, i, j, visited);
                        result[ship-1]++;
                    }
                }
            }
        }

        return result;
    }

    private static int find_ship(String[] board, int i, int j, int[][] visited) {
        int ship_size = 1;
        visited[i][j] = 1;

        while(board[i].charAt(j) == '#') {
            char ch_top = safe_get(board, i-1, j, visited);
            char ch_bottom = safe_get(board, i+1, j, visited);
            char ch_left = safe_get(board, i, j-1, visited);
            char ch_right = safe_get(board, i, j+1, visited);

            if(ch_top != '#' && ch_bottom != '#' && ch_left != '#' && ch_right != '#') {
                break;
            }

            if(ch_top == '#') {
                ship_size += find_ship(board, i-1, j, visited);
            }
            if(ch_bottom == '#') {
                ship_size += find_ship(board, i+1, j, visited);
            }
            if(ch_left == '#') {
                ship_size += find_ship(board, i, j-1, visited);
            }
            if(ch_right == '#') {
                ship_size += find_ship(board, i, j+1, visited);
            }
        }

        return ship_size;
    }

    private static char safe_get(String[] board, int i, int j, int[][] visited) {
        try {
            if(visited[i][j] == 1) {
                return '.';
            }
            return board[i].charAt(j);
        }
        catch(Exception e) {
            return '.';
        }
    }


    public static int solution_1(String s) {
        // s is a string with either characters >, < and .
        // > denotes cars going to the right
        // < denotes cars going to the left
        // . denotes a speed camera
        // denote the number of cars that will be caught by the speed cameras

        int dotcount = 0;
        int rightcount = 0;
        int leftcount = 0;
        int rightCars = 0;
        int leftCars = 0;


        for(int i = 0; i<s.length(); i++) {
            if(s.charAt(i) == '.') {
                dotcount++;
                rightCars += rightcount;
            }
            if(s.charAt(i) == '>') {
                rightcount++;
            }
        }

        dotcount = 0;
        for(int i = 0; i<s.length(); i++) {
            if(s.charAt(i) == '.') {
                dotcount++;
            }
            if(s.charAt(i) == '<') {
                leftcount++;
                leftCars += dotcount;
            }
        }

        return rightCars + leftCars;
    }
    public static void main(String[] args) {
//        System.out.println(solution_1(".>..."));
//        System.out.println(solution_1(".>.<.>"));
//        System.out.println(solution_1(">>>.<<<"));

//        String[] board = new String[] {
//                "##.",
//                "#.#",
//                ".##",
//        };

//        String[] board = new String[] {
//                ".##.#",
//                "#.#..",
//                "#...#",
//                "#.##.",
//        };

                String[] board = new String[] {
                ".#..#",
                "##..#",
                "...#.",
        };

        int[] result = warships_solution(board);

        System.out.println(result[0] + "," + result[1] + "," + result[2]);
    }
}