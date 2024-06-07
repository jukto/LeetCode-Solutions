// Problem: https://leetcode.com/problems/determine-if-string-halves-are-alike/

public class Solution {
    private HashSet<char> vowels = [ 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' ];

    public bool HalvesAreAlike(string s) {
        int count = 0;

        for (int i = s.Length / 2 - 1; i >= 0; i--) {
            if (vowels.Contains(s[i])) count++;
        }

        for (int i = s.Length / 2; i < s.Length; i++) {
            if (vowels.Contains(s[i])) count--;
        }
        
        return count == 0;
    }
}
