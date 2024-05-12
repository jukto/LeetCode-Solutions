// Problem: https://leetcode.com/problems/largest-local-values-in-a-matrix/

public class Solution {
    public int[][] LargestLocal(int[][] grid) {
        int n = grid.Length, nn = n - 2;
        var result = new int[nn][];
        for (int i = 0; i < nn; i++) {
            result[i] = new int[nn];
        }

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                int val = grid[x][y];

                int xhi = Math.Min(nn - 1, x);
                int yhi = Math.Min(nn - 1, y);

                for (int xx = Math.Max(0, x - 2); xx <= xhi; xx++) {
                    for (int yy = Math.Max(0, y - 2); yy <= yhi; yy++) {
                        result[xx][yy] = Math.Max(result[xx][yy], val);
                    }
                }
            }
        }

        return result;
    }
}
