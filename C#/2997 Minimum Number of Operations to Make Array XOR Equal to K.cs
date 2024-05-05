//  Problem: https://leetcode.com/problems/minimum-number-of-operations-to-make-array-xor-equal-to-k/

public class Solution {
    public int MinOperations(int[] nums, int k) {
        int sum = 0, result = 0;

        foreach (var num in nums) {
            sum ^= num;
        }
        
        for (int b = 0; b < 32; b++) {
            int bit = 1 << b;
            if ((sum & bit) != (k & bit)) {
                result++;
            }
        }
        
        return result;
    }
}
