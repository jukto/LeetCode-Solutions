// Problem: https://leetcode.com/problems/type-of-triangle/

public class Solution {
    public string TriangleType(int[] nums) {
        Array.Sort(nums);
        int x = nums[0], y = nums[1], z = nums[2];

        if (x == z) {
            return "equilateral";
        }

        if (x + y <= z) {
            return "none";
        }

        if (x == y || y == z) {
            return "isosceles";
        }

        return "scalene";
    }
}
