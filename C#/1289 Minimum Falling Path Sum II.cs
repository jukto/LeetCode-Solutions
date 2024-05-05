// Problem: https://leetcode.com/problems/minimum-falling-path-sum-ii/

public class Solution {
    public int MinFallingPathSum(int[][] grid) {
        int n = grid.Length;
        int minDex1 = 0, minVal1 = int.MaxValue, minVal2 = int.MaxValue;
        int _minDex1 = 0, _minVal1, _minVal2;

        for (int i = 0; i < n; i++) {
            int val = grid[0][i];

            if (val < minVal1) {
                minVal2 = minVal1;

                minVal1 = val;
                minDex1 = i;
            } else if (val < minVal2) {
                minVal2 = val;
            }
        }

        for (int i = 1; i < n; i++) {
            _minVal1 = _minVal2 = int.MaxValue;

            for (int k = 0; k < n; k++) {
                int val = grid[i][k] + ( (k != minDex1) ? minVal1 : minVal2 );

                if (val < _minVal1) {
                    _minVal2 = _minVal1;
                    _minVal1 = val;
                    _minDex1 = k;
                } else if (val < _minVal2) {
                    _minVal2 = val;
                }
            }

            minDex1 = _minDex1;
            minVal1 = _minVal1;
            minVal2 = _minVal2;
        }

        return minVal1;
    }
}
