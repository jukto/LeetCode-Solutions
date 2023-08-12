//  Problem: https://leetcode.com/problems/sudoku-solver

class Solution {
    public void solveSudoku(char[][] board) {
        // Create and populate three boolean arrays to keep track of what numbers each row/column/sub-box contains.
        boolean[][] rows = new boolean[9][10];
        boolean[][] columns = new boolean[9][10];
        boolean[][][] boxes = new boolean[3][3][10];

        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                if (board[y][x] != '.') {
                    int num = board[y][x] - '0';
                    rows[y][num] = true;
                    columns[x][num] = true;
                    boxes[y / 3][x / 3][num] = true;
                }
            }
        }

        recursion(board, rows, columns, boxes, 0, 0);
    }

    // Depth-first search trying each available value in each unfilled square and backtracking.
    boolean recursion(char[][] board, boolean[][] rows, boolean[][] columns, boolean[][][] boxes, int y, int x) {
        while (board[y][x] != '.') {
            if (++x == 9) {
                if (++y == 9) return true;
                x = 0;
            }
        }

        boolean[] row = rows[y], column = columns[x], box = boxes[y / 3][x / 3];
        
        for (int num = 1; num <= 9; num++) {
            if (!row[num] && !column[num] && !box[num]) {
                board[y][x] = (char)(num + '0');
                row[num] = true;
                column[num] = true;
                box[num] = true;

                // If a viable solution was reached from this value, return early.
                if ( recursion(board, rows, columns, boxes, y, x) ) return true;

                row[num] = false;
                column[num] = false;
                box[num] = false;
            }
        }

        board[y][x] = '.';
        return false;
    }
}
