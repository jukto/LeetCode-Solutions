//  Problem: https://leetcode.com/problems/find-the-score-of-all-prefixes-of-an-array/

class Solution {
    public long[] findPrefixScore(int[] nums) {
        int n = nums.length, max = nums[0];
        long score[] = new long[n], sum = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            sum += nums[i] + max;
            score[i] = sum;
        }

        return score;
    }
}
