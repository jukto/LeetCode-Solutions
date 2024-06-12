// Problem: https://leetcode.com/problems/sort-characters-by-frequency/

public class Solution {
    public string FrequencySort(string s) {
        var bucket = new List<char>[s.Length + 1];
        var map = new Dictionary<char, int>();
        var sb = new StringBuilder(s.Length);

        foreach (var c in s) {
            if (map.ContainsKey(c)) map[c]++;
            else map.Add(c, 1);
        }

        foreach (var (c, f) in map) {
            if (bucket[f] == null)
                bucket[f] = [];

            bucket[f].Add(c);
        }

        for (int i = s.Length; i >= 0; i--) {
            if (bucket[i] != null) {
                foreach (var c in bucket[i]) {
                    sb.Append(c, i);
                }
            }
        }

        return sb.ToString();
    }
}
