// Problem: https://leetcode.com/problems/sum-of-all-subset-xor-totals/

public class Solution {
    public int SubsetXORSum(int[] nums) {
        return RecXOR(0, nums, 0);
    }

    private int RecXOR(int running, int[] nums, int i) {
        if (i == nums.Length) {
            return running;
        }

        return RecXOR(running, nums, i + 1) + RecXOR(running ^ nums[i], nums, i + 1);
    }
}
