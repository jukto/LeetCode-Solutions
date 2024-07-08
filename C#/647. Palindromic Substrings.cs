// Problem: https://leetcode.com/problems/palindromic-substrings/

public class Solution {
    public int CountSubstrings(string s) {
        var result = 0;

        for (int i = 0; i < s.Length; i++)
            result += Palindrate(s, i, i) + Palindrate(s, i, i + 1);
        
        return result;
    }

    private int Palindrate(string s, int l, int r) {
        return (l < 0 || r >= s.Length || s[l] != s[r]) ? 0 : Palindrate(s, l - 1, r + 1) + 1;
    }
}
