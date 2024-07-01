// Problem: https://leetcode.com/problems/three-consecutive-odds/

public class Solution {
    public bool ThreeConsecutiveOdds(int[] arr) {
        int n = arr.Length;

        if (n < 3) return false;

        int l = 0, r = 0, c = 0;

        while (r < 3) {
            if (arr[r++] % 2 == 1) c++;
        }

        if (c == 3) return true;

        while (r < n) {
            if (arr[l++] % 2 == 1) c--;
            if (arr[r++] % 2 == 1) c++;
            if (c == 3) return true;
        }

        return false;
    }
}
