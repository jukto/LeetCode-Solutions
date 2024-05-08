// Problem: https://leetcode.com/problems/relative-ranks/

public class Solution {
    public string[] FindRelativeRanks(int[] score) {
        int n = score.Length;
        var result = new string[n];
        int[][] sortArray = new int[n][];

        for (int i = 0; i < n; i++) {
            sortArray[i] = new int[] { i, score[i] };
        }

        Array.Sort(sortArray, Comparer<int[]>.Create((x, y) => y[1] - x[1]));

        for (int i = 0; i < n; i++) {
            result[sortArray[i][0]] = GetPlace(i + 1);
        }

        return result;
    }

    private static string GetPlace(int place) {
        return place switch {
            1 => "Gold Medal",
            2 => "Silver Medal",
            3 => "Bronze Medal",
            _ => place.ToString()
        };
    }
}
