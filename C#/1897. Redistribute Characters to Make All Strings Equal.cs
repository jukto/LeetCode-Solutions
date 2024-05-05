// Problem: https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal/

public class Solution {
    public bool MakeEqual(string[] words) {
        var counts = new int[26];
        var n = words.Length;

        foreach (var word in words) {
            foreach (var c in word.ToCharArray()) {
                counts[c - 'a']++;
            }
        }

        foreach (var i in counts) {
            if (i % n != 0) {
                return false;
            }
        }

        return true;
    }
}
