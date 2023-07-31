//  Problem: https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/description/

class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        // Convert strings to arrays for faster access and define a dp array where
        // dp[i][j] represents the minimum sums where s1[0:i] equals s2[0:j].
        char[] arr1 = s1.toCharArray(), arr2 = s2.toCharArray();
        int[][] dp = new int[arr1.length + 1][arr2.length + 1];

        // initialize dp edge values as cost of deleting all characters in s1/2 up to i/j
        for (int i = 0; i < arr1.length; i++)
            dp[i + 1][0] = dp[i][0] + arr1[i];
        
        for (int j = 0; j < arr2.length; j++)
            dp[0][j + 1] = dp[0][j] + arr2[j];
        
        // for each s1[i]/s2[j] combination: if the characters match, the cost remains the same as s1[i-1]/s2[j-1],
        // otherwise the cost is equal to (the cost of matching s1[0:i-1] to s2[0:j] plus s1[i]) or 
        // (the cost of matching s1[0:i] to s2[0:j-1] plus s2[j]), whichever is lower.
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                dp[i + 1][j + 1] = (arr1[i] == arr2[j]) ? dp[i][j] : Integer.min(dp[i][j + 1] + arr1[i], dp[i + 1][j] + arr2[j]);
            }
        }
        
        return dp[arr1.length][arr2.length];
    }
}
