class Solution {
    public int getMaximumGold(int[][] grid) {
        int maxGold = 0;

        for(int x = 0; x < grid.length; x++) {
            for(int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] > 0) {
                    maxGold = Math.max(maxGold, recursion(grid, x, y));
                }
            }
        }

        return maxGold;
    }

    private int recursion(int[][] grid, int x, int y) {
        int gold = grid[x][y], goldNext = 0;
        grid[x][y] = 0;

        if (x > 0 && grid[x-1][y] > 0) {
            goldNext = recursion(grid, x - 1, y);
        }

        if (x < grid.length - 1 && grid[x+1][y] > 0) {
            goldNext = Math.max(goldNext, recursion(grid, x + 1, y));
        }
        
        if (y > 0 && grid[x][y-1] > 0) {
            goldNext = Math.max(goldNext, recursion(grid, x, y - 1));
        }

        if (y < grid[0].length - 1 && grid[x][y+1] > 0) {
            goldNext = Math.max(goldNext, recursion(grid, x, y + 1));
        }
        
        grid[x][y] = gold;
        return gold + goldNext;
    }
}
