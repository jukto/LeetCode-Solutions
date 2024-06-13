// Problem: https://leetcode.com/problems/island-perimeter/

public class Solution {
    public int IslandPerimeter(int[][] grid) {
        var result = 0;

        for (var y = 0; y < grid.Length; y++) {
            for (var x = 0; x < grid[0].Length; x++) {
                if (grid[y][x] == 1) {

                    if (y == 0 || grid[y - 1][x] == 0) {
                        result++;
                    }
                    
                    if (y == grid.Length - 1 || grid[y + 1][x] == 0) {
                        result++;
                    }
                    
                    if (x == 0 || grid[y][x - 1] == 0) {
                        result++;
                    }
                    
                    if (x == grid[0].Length - 1 || grid[y][x + 1] == 0) {
                        result++;
                    }
                }
            }
        }

        return result;
    }
}
