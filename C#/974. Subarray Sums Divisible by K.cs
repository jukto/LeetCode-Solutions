// Problem: https://leetcode.com/problems/subarray-sums-divisible-by-k/

public class Solution {
    public int SubarraysDivByK(int[] nums, int k) {
        int sum = 0, result = 0;
        var array = new int[k];
        array[0] = 1;

        foreach (var num in nums) {
            sum += num;
            int rem = sum % k;

            if (rem < 0) {
                rem += k;
            }

            result += array[rem];
            array[rem]++;
        }

        return result;
    }
}
