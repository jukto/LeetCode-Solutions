// Problem: https://leetcode.com/problems/maximum-score-from-removing-stones/

public class Solution {
    public int MaximumScore(int a, int b, int c) {
        int max = Math.Max(Math.Max(a, b), c);
        int other = a + b + c - max;
        
        if (other > max) {
            return (other + max) / 2;
        }
        return other;
    }
}
