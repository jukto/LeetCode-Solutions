// Problem: https://leetcode.com/problems/longest-palindrome/

public class Solution {
    public int LongestPalindrome(string s) {
        var array = new bool[123];
        int result = 0;

        foreach (var c in s) {
            if (array[c]) {
                result += 2;
                array[c] = false;
            } else {
                array[c] = true;
            }
        }

        for (int i = 'A'; i <= 'z'; i++) {
            if (array[i]) {
                result++;
                break;
            }
        }

        return result;
    }
}
