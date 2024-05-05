// Problem: https://leetcode.com/problems/maximize-area-of-square-hole-in-grid/

public class Solution {
    public int MaximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        return (int)Math.Pow( Math.Min(MaxGap(hBars), MaxGap(vBars)), 2 );
    }

    private int MaxGap(int[] array) {
        int count = 2, result = 2;

        Array.Sort(array);

        for (int i = 1; i < array.Length; i++) {
            if (array[i - 1] + 1 == array[i]) {
                result = Math.Max(result, ++count);
            } else {
                count = 2;
            }
        }

        return result;
    }
}
