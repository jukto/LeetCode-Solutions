class Solution {
    public int jump(int[] nums) {
        int n = nums.length - 1, jumps = 0, reach = 0, max = 0;

        for (int i = 0; reach < n; i++) {
            max = Integer.max(max, i + nums[i]);
            if (i == reach) {
                jumps++;
                reach = max;
            }
        }

        return jumps;
    }
}
