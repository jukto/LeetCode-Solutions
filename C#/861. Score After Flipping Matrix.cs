// Problem: https://leetcode.com/problems/score-after-flipping-matrix/

public class Solution {
    public int MatrixScore(int[][] grid) {
        int result = grid.Length;

        for (int y = 0; y < grid.Length; y++) {
            if(grid[y][0] == 0) {
                for (int x = 0; x < grid[y].Length; x++) {
                    grid[y][x] ^= 1;
                }
            }
        }
        
        for (int x = 1; x < grid[0].Length; x++) {
            int ones = 0, zeros = 0;
            for (int y = 0; y < grid.Length; y++) {
                if (grid[y][x] == 1) {
                    ones++;
                } else {
                    zeros++;
                }
            }
            result *= 2;
            result += Math.Max(zeros, ones);
        }

        return result;
    }
}
