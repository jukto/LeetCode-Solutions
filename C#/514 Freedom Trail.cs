// Problem: https://leetcode.com/problems/freedom-trail/

public class Solution {
    private List<int>[] indexMemo = new List<int>[123];
    private int[][] pathMemo;

    public int FindRotateSteps(string ring, string key) {
        int length = ring.Length;

        pathMemo = new int[key.Length][];
        for (int i = 0; i < key.Length; i++) {
            pathMemo[i] = new int[ring.Length];
        }

        return DFS(ring, 0, key, 0) + key.Length;
    }

    private int DFS(string ring, int rDex, string key, int kDex) {
        if (kDex == key.Length) return 0;

        if (pathMemo[kDex][rDex] != 0) {
            return pathMemo[kDex][rDex];
        }

        int min = int.MaxValue;
        foreach (var p in FindAll(ring, key[kDex])) {
            min = Math.Min(min, DFS(ring, p, key, kDex + 1) + MinStepsTo(rDex, p, ring.Length));
        }

        return pathMemo[kDex][rDex] = min;
    }

    private List<int> FindAll(string ring, char target) {
        if (indexMemo[target] != null) {
            return indexMemo[target];
        }
        var result = new List<int>();

        var arr = ring.ToCharArray();

        for (int i = 0; i < arr.Length; i++) {
            if (arr[i] == target) {
                result.Add(i);
            }
        }

        return indexMemo[target] = result;
    }

    private int MinStepsTo(int current, int target, int length) {
        int left, right;

        if (current == target) {
            return 0;
        } else if (current <= target) {
            left = (length - target) + current;
            right = target - current;
        } else {
            left = current - target;
            right = (length - current) + target;
        }

        return Math.Min(left, right);
    }
}
