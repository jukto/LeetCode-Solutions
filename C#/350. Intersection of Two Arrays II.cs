// Problem: https://leetcode.com/problems/intersection-of-two-arrays-ii/

public class Solution {
    public int[] Intersect(int[] nums1, int[] nums2) {
        int i = 0, k = 0, j = 0;

        Array.Sort(nums1);
        Array.Sort(nums2);

        while (i < nums1.Length && k < nums2.Length) {
            int n1 = nums1[i], n2 = nums2[k];

            if (n1 < n2) i++;
            else if (n1 > n2) k++;
            else {
                nums1[j++] = n1;
                i++;
                k++;
            }
        }

        Array.Resize(ref nums1, j);
        return nums1;
    }
}
