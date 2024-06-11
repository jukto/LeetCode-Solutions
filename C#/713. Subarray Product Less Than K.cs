// Problem: https://leetcode.com/problems/subarray-product-less-than-k/

public class Solution {
    public int NumSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;

        int i = 0, product = 1, result = 0;

        for (int j = 0; j < nums.Length; j++) {
            product *= nums[j];

            while (product >= k) {
                product /= nums[i];
                i++;
            }

            result += j + 1 - i;
        }

        return result;
    }
}
