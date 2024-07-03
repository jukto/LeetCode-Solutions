// Problem: https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/

public class Solution {
    public int MinDifference(int[] nums) {
        if (nums.Length <= 4) return 0;

        Array.Sort(nums);

        return Math.Min(
            Math.Min(MaxDiff(nums, 0, nums.Length - 3), MaxDiff(nums, 3, nums.Length)),
            Math.Min(MaxDiff(nums, 1, nums.Length - 2), MaxDiff(nums, 2, nums.Length - 1))
        );
    }

    private int MaxDiff(int[] nums, int left, int right) {
        int min = nums[left], max = nums[left];

        for (int i = left; i < right; i++) {
            min = Math.Min(min, nums[i]);
            max = Math.Max(max, nums[i]);
        }

        return max - min;
    }
}
