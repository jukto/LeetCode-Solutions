//  Problem: https://leetcode.com/problems/next-permutation/description/

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length, pivot = n - 2;

        // The pivot will be the index of the last value that is smaller than the value to its left.
        // If there is no such index (the permutation is in reverse order), pivot will be -1.
        // We can find the next possible permutation by incrementing this pivot to the next possible value 
        // and then sorting every element to the right of it in increasing order.
        while (pivot >= 0 && nums[pivot] >= nums[pivot + 1])
            pivot--;

        // If pivot is -1 at this point, then nums is currently in reverse order and we need to sort the entire thing.
        // Otherwise, we increment nums[pivot] to the next possible value.
        if (pivot != -1)
            swapNext(nums, pivot);

        // At this point, we know that everything to the right of pivot is in reverse order.
        // So we can sort it by simply reversing it.
        while (++pivot < --n)
            swap(nums, pivot, n);
    }

    // Find the last value in nums that is greater than nums[i], and swap them.
    // This maintains nums[i+1:] in reverse order.
    private void swapNext(int[] nums, int i) {
        int k = nums.length - 1;
        while (nums[k] <= nums[i])
            k--;
        swap(nums, i, k);
    }

    private void swap(int[] nums, int i, int k) {
        int tmp = nums[i];
        nums[i] = nums[k];
        nums[k] = tmp;
    }
}
