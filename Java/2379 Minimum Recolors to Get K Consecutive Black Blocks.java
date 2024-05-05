//  Problem: https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/

class Solution {
    public int minimumRecolors(String blocks, int k) {
        char[] s = blocks.toCharArray();
        int n = s.length, window = 0, min = k;

        // Sliding window to find the k-length subsequence with the fewest 'W' chars.
        for (int i = 0; i < n; i++) {
            if (s[i] == 'W')
                window++;

            if (i >= k && s[i - k] == 'W')
                window--;

            if (i >= k - 1 && window < min)
                min = window;
        }

        return min;
    }
}
