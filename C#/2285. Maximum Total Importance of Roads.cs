// Problem: https://leetcode.com/problems/maximum-total-importance-of-roads/

public class Solution {
    public long MaximumImportance(int n, int[][] roads) {
        long[] array = new long[n];
        long result = 0;

        foreach (var road in roads) {
            array[road[0]]++;
            array[road[1]]++;
        }

        Array.Sort(array, (a, b) => b.CompareTo(a));

        for (int i = 0; i < n; i++) {
            result += array[i] * (n - i);
        }

        return result;
    }
}
