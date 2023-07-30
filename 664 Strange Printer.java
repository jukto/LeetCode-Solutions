//  Problem: https://leetcode.com/problems/strange-printer/description/

class Solution {
    public int strangePrinter(String s) {
        return recursion(s.toCharArray(), 0, s.length() - 1, new int[s.length()][s.length()]);
    }

    private int recursion(char[] s, int start, int end, int[][] memo) {
        // if substring is 1 character long, it can be printed in one operation
        if (start == end) return 1;

        // if we've already found the minimum operations for this substring, return that
        if (memo[start][end] != 0)
            return memo[start][end];

        // if the last character equals the character before it or the first character, then
        // it can be printed for free during an operation on s[start:end - 1].
        if (s[start] == s[end] || s[end - 1] == s[end])
            return memo[start][end] = recursion(s, start, end - 1, memo);

        // if the first character equals the second character, then it can be printed for
        // free during an operation on s[start + 1:end].
        if (s[start] == s[start + 1])
            return memo[start][end] = recursion(s, start + 1, end, memo);
        
        // if none of the above are true, we consider all other options through a divide-and-conquer approach.
        int result = recursion(s, start, end - 1, memo) + 1;

        for (int i = start + 1; i < end; i++) {
            if (s[i] == s[end]) {
                result = Integer.min(result, recursion(s, start, i - 1, memo) + recursion(s, i, end - 1, memo));
            }
        }

        return memo[start][end] = result;
    }
}
