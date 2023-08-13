//  Problem: https://leetcode.com/problems/longest-ideal-subsequence

class Solution {
    public int longestIdealString(String s, int k) {
        // Let dp[c] be the maximum length of any ideal subsequence that ends with char c.
        int dp[] = new int[149], max = 0;

        // For each c in s, dp[c] is the maximum dp[i] within k of c plus one.
        for (char c : s.toCharArray()) {
            int localMax = 0;
            for (int j = c - k; j <= c + k; j++)
                localMax = Math.max(localMax, dp[j]);
            max = Math.max(max, dp[c] = ++localMax);
        }

        return max;
    }
}
