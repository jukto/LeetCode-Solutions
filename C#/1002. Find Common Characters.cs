// Problem: https://leetcode.com/problems/find-common-characters/

public class Solution {
    public IList<string> CommonChars(string[] words) {
        var result = new List<string>();
        var mins = new int[26];
        
        foreach (var c in words[0]) {
            mins[c - 'a']++;
        }

        for (int i = 1; i < words.Length; i++) {
            var arr = new int[26];

            foreach (var c in words[i]) {
                arr[c - 'a']++;
            }

            for (int k = 0; k < 26; k++) {
                mins[k] = Math.Min(mins[k], arr[k]);
            }
        }

        for (char c = 'a'; c <= 'z'; c++) {
            int i = mins[c - 'a'];

            while (i-- > 0) {
                result.Add(new string(c, 1));
            }
        }

        return result;
    }
}
