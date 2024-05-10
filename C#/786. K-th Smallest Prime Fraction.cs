// Problem: https://leetcode.com/problems/k-th-smallest-prime-fraction/

public class Solution {
    public int[] KthSmallestPrimeFraction(int[] arr, int k) {
        double lo = 0, hi = 1;
        int[] result = new int[2];
        int n = arr.Length;

        while (hi - lo > 1e-8) {
            double mid = (lo + hi) / 2;
            int t = 0, j = 1;
            int num = 0, den = 1;

            for (int i = 0; i < n - 1; i++) {
                while (j < n && arr[i] > mid * arr[j]) { j++; }
                if (j < n) {
                    t += n - j;

                    if (arr[i] * den > arr[j] * num) {
                        num = arr[i];
                        den = arr[j];
                    }
                }
            }

            if (t < k) {
                lo = mid;
            } else {
                hi = mid;
                result[0] = num;
                result[1] = den;
            }
        }

        return result;
    }
}
