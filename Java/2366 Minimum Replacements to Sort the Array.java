//  Problem: https://leetcode.com/problems/minimum-replacements-to-sort-the-array/

class Solution {
    public long minimumReplacement(int[] nums) {
        int n = nums.length, right = nums[n - 1], mod;
        long replacements = 0;

        // Let num be a member of nums, and right be the element to its right (which must be >= num).
        // For each num in reverse order, we need to find the number of replacements required to make it valid, as well as
        // the leftmost value if the elements it is replaced with, as this will be the next num's right.
        for (int i = n - 2; i >= 0; i--) {
            int num = nums[i];

            // If num <= right, then it's already valid.
            if (num > right) {

                // If num is equally divisible by right, then it can be broken up into (num / right) elements of
                // value == right in (num / right - 1) operations. The value of right is unchanged.
                if ((mod = num % right) == 0) {
                    replacements += num / right - 1;


                // If num is not equally divisible by right, then it can be broken into (num / right + 1) elements,
                // and num is (right - (num % right)) too small to fill each of these elements with right.
                // To ensure the leftmost element's value is as high as possible, we spread this difference across the new elements.
                } else {
                    int minCount = num / right;
                    replacements += minCount++;
                    right -= (int)Math.ceil((double)(right - mod) / minCount);
                }
            } else {
                right = num;
            }
        }

        return replacements;
    }
}
