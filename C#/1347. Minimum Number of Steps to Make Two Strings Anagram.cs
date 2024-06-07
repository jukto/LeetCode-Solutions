// Problem: https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/

public class Solution {
    public int MinSteps(string s, string t) {
        var count = new int[26];
        var result = 0;

        for (int i = 0; i < s.Length; i++) {
            count[s[i] - 'a']++;
            count[t[i] - 'a']--;
        }

        foreach (var c in count) {
            if (c > 0) result += c;
        }

        return result;
    }
}
