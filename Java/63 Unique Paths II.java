//  Problem: https://leetcode.com/problems/unique-paths-ii

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // For effeciency's sake, we're reusing the input grid as a dp cache.
        // each dp[y][x] = the number of ways to reach this point.
        int m = obstacleGrid.length, n = obstacleGrid[0].length, total = m + n;
        obstacleGrid[0][0] = (obstacleGrid[0][0] == 1) ? 0 : 1;

        // Sweep through the grid diagonally (processing each point in a NE-SW diagonal before moving on)
        // For each point check if an obstacle exists:
        // if one does, then there are 0 ways to reach this point as it's unreachable;
        // otherwise it can be reached from points dp[y - 1][x] and dp[y][x - 1],
        // so the number of ways it can be reached is the sum of these.
        for (int i = 1; i <= total; i++) {
            int y = Integer.min(i, m - 1);
            int x = i - y;

            while (y >= 0 && x < n) {

                if (obstacleGrid[y][x] == 0) {
                    if (y > 0) 
                        obstacleGrid[y][x] += obstacleGrid[y - 1][x];
                    if (x > 0)
                        obstacleGrid[y][x] += obstacleGrid[y][x - 1];
                } else {
                    obstacleGrid[y][x] = 0;
                }

                y--;
                x++;
            }
        }

        return obstacleGrid[m - 1][n - 1];
    }
}
