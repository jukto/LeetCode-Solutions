//  Problem: https://leetcode.com/problems/fibonacci-number/description/

class Solution {
    private int[] memo = new int[31];

    public Solution() {
        memo[1] = memo[2] = 1;
    }

    public int fib(int n) {
        if (n <= 2 || memo[n] != 0) return memo[n];
        return memo[n] = fib(n - 1) + fib(n - 2);
    }
}
