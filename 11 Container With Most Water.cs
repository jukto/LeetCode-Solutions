// Problem: https://leetcode.com/problems/container-with-most-water/

public class Solution {
    public int MaxArea(int[] height) {
        int left = 0, right = height.Length - 1;
        int area = Area(left, right, height);

        while (left != right) {
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }

            area = Math.Max(area, Area(left, right, height));
        }

        return area;
    }

    private int Area(int left, int right, int[] height) {
        return (right - left) * Math.Min(height[left], height[right]);
    }
}
