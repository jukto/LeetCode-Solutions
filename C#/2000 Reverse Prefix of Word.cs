// Problem: https://leetcode.com/problems/reverse-prefix-of-word/

public class Solution {
    public string ReversePrefix(string word, char ch) {
        var pivot = word.IndexOf(ch);
        if (pivot < 0) {
            return word;
        }

        var array = word.ToCharArray();
        Array.Reverse(array, 0, pivot + 1);

        return new string(array);
    }
}
