// Problem: https://leetcode.com/problems/minimum-time-to-revert-word-to-initial-state-ii/

public class Solution {
    public int MinimumTimeToInitialState(string word, int k) {
        int result = 1, n = word.Length, l = 0, r = 0;
        var z = new int[n];

        for (int i = 1; i < n; i++) {
            if (i < r) {
                z[i] = Math.Min(r - i, z[i - l]);
            }

            while (i + z[i] < n && word[z[i]] == word[i + z[i]]) {
                z[i]++;
            }

            if (i + z[i] > r) {
                l = i;
                r = i + z[i];
            }
        }

        for (int i = 0; i < n; i++) {
            if (n - z[i] == i && i % k == 0) {
                return i / k;
            }
        }

        return (int)Math.Ceiling(n / (double)k);
    }
}
