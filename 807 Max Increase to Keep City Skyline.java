class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] maxX = new int[grid.length], maxY = new int[grid[0].length];
        int sum = 0;

        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                int val = grid[x][y];
                if (val > maxX[x]) maxX[x] = val;
                if (val > maxY[y]) maxY[y] = val;
            }
        }

        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                sum += Math.min(maxX[x], maxY[y]) - grid[x][y];
            }
        }
        
        return sum;
    }
}
