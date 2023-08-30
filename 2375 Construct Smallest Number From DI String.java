// Problem: https://leetcode.com/problems/construct-smallest-number-from-di-string/

class Solution {
    public String smallestNumber(String pattern) {
        var result = new char[pattern.length() + 1];
        recursion(result, pattern.toCharArray(), -1, 0, new boolean[10]);
        return new String(result);
    }

    // DFS with a splash of backtracking
    boolean recursion(char[] result, char[] p, int i, int last, boolean[] used) {
        if (i == p.length) return true;

        int left, right;
        if (i == -1 || p[i] == 'I') {
            left = last + 1;
            right = 10;
        } else {
            left = 1;
            right = last;
        }

        i++;

        for (int k = left; k < right; k++) {
            if (!used[k]) {
                used[k] = true;
                if (recursion(result, p, i, k, used)) {
                    result[i] = (char)(k +'0');
                    return true;
                }
                used[k] = false;
            }
        }

        return false;
    }
}
