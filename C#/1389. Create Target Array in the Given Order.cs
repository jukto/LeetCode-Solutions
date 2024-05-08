// Problem: https://leetcode.com/problems/create-target-array-in-the-given-order/

public class Solution {
    public int[] CreateTargetArray(int[] nums, int[] index) {
        var n = nums.Length;
        var target = new List<int>(n);

        for (int i = 0; i < n; i++) {
            target.Insert(index[i], nums[i]);
        }
        
        return target.ToArray();
    }
}
