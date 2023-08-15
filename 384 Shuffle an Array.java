//  Problem: https://leetcode.com/problems/shuffle-an-array

class Solution {
    Random rand = new Random();
    int orig[], nums[], n;

    public Solution(int[] nums) {
        n = nums.length;
        orig = Arrays.copyOf(nums, n);
        this.nums = nums;
    }
    
    public int[] reset() {
        return nums = Arrays.copyOf(orig, n);
    }
    
    public int[] shuffle() {
        for (int i = 0; i < n; i++)
            swap(i, rand.nextInt(n));
        return nums;
    }

    void swap(int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
