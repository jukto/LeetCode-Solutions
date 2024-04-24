//  Problem: https://leetcode.com/problems/n-th-tribonacci-number/

public class Solution {
    private static int[] memo = new int[38];

    static Solution() {
        memo[1] = 1;
        memo[2] = 1;
    }

    public int Tribonacci(int n) {
        if (n == 0) {
            return 0;
        }

        if (memo[n] > 0) {
            return memo[n];
        }

        return memo[n] = Tribonacci(n - 1) + Tribonacci(n - 2) + Tribonacci(n - 3);
    }
}
