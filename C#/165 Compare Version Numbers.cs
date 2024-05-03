// Problem: https://leetcode.com/problems/compare-version-numbers/

public class Solution {
    public int CompareVersion(string version1, string version2) {
        string[] v1 = version1.Split('.'), v2 = version2.Split('.');
        var maxLen = Math.Max(v1.Length, v2.Length);

        for (int i = 0; i < maxLen; i++) {
            int n1 = (i >= v1.Length) ? 0 : int.Parse(v1[i]);
            int n2 = (i >= v2.Length) ? 0 : int.Parse(v2[i]);

            if (n1 != n2) {
                return n1 > n2 ? 1 : -1;
            }
        }
        
        return 0;
    }
}
