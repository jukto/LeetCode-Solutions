// Problem: https://leetcode.com/problems/intersection-of-two-arrays/

public class Solution {
    public int[] Intersection(int[] nums1, int[] nums2) {
        var result = new List<int>();
        var array = new bool[1001];

        foreach (var num in nums1) {
            array[num] = true;
        }

        foreach (var num in nums2) {
            if (array[num]) {
                array[num] = false;
                result.Add(num);
            }
        }

        return result.ToArray();
    }
}
