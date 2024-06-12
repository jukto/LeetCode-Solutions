// Problem: https://leetcode.com/problems/sort-colors/

public class Solution {
    // One-pass, constant extra space implementation
    public void SortColors(int[] nums) {
        int i = 0, r = 0, b = nums.Length - 1;

        while (i <= b) {
            if (nums[i] == 0) {
                (nums[i], nums[r]) = (nums[r], nums[i]);
                if (i <= ++r) i++;

            } else if (nums[i] == 1) {
                i++;

            } else if (nums[i] == 2) {
                (nums[i], nums[b]) = (nums[b--], nums[i]);
            }
        }
    }
}
