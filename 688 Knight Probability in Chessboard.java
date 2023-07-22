class Solution {
    private static final int[][] moves = new int[][] { {1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1} };

    public double knightProbability(int n, int k, int row, int column) {
        return recursion(new double[k][n][n], n, k, row, column);
    }

    private static double recursion(double[][][] memo, int n, int k, int row, int column) {
        if (row < 0 || column < 0 || row >= n || column >= n) return 0.0;
        if (k == 0) return 1.0;

        if (memo[--k][row][column] != 0) return memo[k][row][column];

        double result = 0.0;
        for (int[] move : moves) {
            result += recursion(memo, n, k, row + move[0], column + move[1]);
        }

        return memo[k][row][column] = result / 8.0;
    }
}
