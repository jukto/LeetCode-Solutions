class Solution {
    public int surfaceArea(int[][] grid) {
        int n = grid.length, result = n * n * 2;

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                int cubesHere = grid[x][y];
                if (cubesHere == 0) result -= 2;

                if (y == 0) result += cubesHere;
                else if (grid[x][y - 1] >= cubesHere) result += grid[x][y - 1] - cubesHere;
                else result += cubesHere - grid[x][y - 1];

                if (x == 0) result += cubesHere;
                else if (grid[x - 1][y] >= cubesHere) result += grid[x - 1][y] - cubesHere;
                else result += cubesHere - grid[x - 1][y];
            }
            result += grid[x][n - 1];
            result += grid[n - 1][x];
        }

        return result;
    }
}
