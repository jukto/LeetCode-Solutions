// Problem: https://leetcode.com/problems/rank-teams-by-votes/

public class Solution {
    public string RankTeams(string[] votes) {
        int teams = votes[0].Length;

        var scores = new int[teams][];
        var key = new int[26];

        for (int i = 0; i < teams; i++) {
            char c = votes[0][i];
            key[c - 'A'] = i;
            scores[i] = new int[teams + 1];
            scores[i][0] = c;
        }

        foreach (var vote in votes) {
            for (int i = 0; i < teams; i++) {
                scores[key[vote[i] - 'A']][i + 1]++;
            }
        }
        
        Array.Sort(scores, new CustomComparer());

        var result = new char[teams];

        for (int i = 0; i < teams; i++) {
            result[i] = (char)scores[i][0];
        }

        return new(result);
    }

    private class CustomComparer : IComparer<int[]> {
        public int Compare(int[] x, int[] y) {
            for (int i = 1; i < x.Length; i++) {
                int tmp = y[i].CompareTo(x[i]);
                if (tmp != 0) {
                    return tmp;
                }
            }
            return x[0].CompareTo(y[0]);
        }
    }
}
