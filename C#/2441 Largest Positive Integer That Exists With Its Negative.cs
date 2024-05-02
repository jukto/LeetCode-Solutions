// Problem: https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/

public class Solution {
    public int FindMaxK(int[] nums) {
        var set = new HashSet<int>();
        var result = -1;

        foreach (var num in nums) {
            if (Math.Abs(num) > result && set.Contains(-num)) {
                result = Math.Abs(num);
            }
            set.Add(num);
        }
        
        return result;
    }
}
