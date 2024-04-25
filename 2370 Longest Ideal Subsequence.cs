//  Problem: https://leetcode.com/problems/longest-ideal-subsequence/

public class Solution {
    public int LongestIdealString(string s, int k) {
        var lastLength = new int[123];
        var S = s.ToCharArray();
        var max = 1;

        lastLength[S[S.Length - 1]] = 1;

        for (int i = S.Length - 2; i >= 0; i--) {
            var c = S[i];

            var low = Math.Max('a', c - k);
            var high = Math.Min('z', c + k);
            var m = 0;

            while (low <= high) {
                m = Math.Max(m, lastLength[low++]);
            }
            m++;

            lastLength[c] = m;

            max = Math.Max(max, m);
        }

        return max;
    }
}
