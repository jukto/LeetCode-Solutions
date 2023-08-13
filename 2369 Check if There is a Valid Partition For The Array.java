//  Problem: https://leetcode.com/problems/check-if-there-is-a-valid-partition-for-the-array/

class Solution {
    public boolean validPartition(int[] nums) {
        return recursion(nums, 0, new int[nums.length]);
    }

    // Memoized DPS
    boolean recursion(int[] nums, int index, int[] memo) {
        if (index == nums.length) return true;
        if (index == nums.length - 1) return false;
        if (memo[index] != 0) return memo[index] == 1;

        int num1 = nums[index], num2 = nums[index + 1], num3 = (index + 2 < nums.length) ? nums[index + 2] : -1;

        if (num1 == num2) {
            if (recursion(nums, index + 2, memo) || (num1 == num3 && recursion(nums, index + 3, memo))) {
                memo[index] = 1;
                return true;
            }
        } else if (num1 + 1 == num2 && num1 + 2 == num3 && recursion(nums, index + 3, memo)) {
            memo[index] = 1;
            return true;
        }

        memo[index] = -1;
        return false;
    }
}
