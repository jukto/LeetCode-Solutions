//  Problem: https://leetcode.com/problems/kth-largest-element-in-an-array

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1, goal = nums.length - k, pindex;

        while (true) {
            pindex = quickPartition(nums, left, right);

            if (pindex > goal) right = pindex - 1;
            else if (pindex < goal) left = pindex + 1;
            else return nums[pindex];
        }
    }

    // QuickSearch partitioning around the midpoint of left and right.
    int quickPartition(int[] nums, int left, int right) {
        int pindex = (left + right) / 2, pival = nums[pindex];

        swap(nums, pindex, right);

        for (int i = left; i < right; i++)
            if (nums[i] < pival) swap(nums, i, left++);

        swap(nums, right, left);

        return left;
    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
