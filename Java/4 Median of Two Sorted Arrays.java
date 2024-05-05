class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int midpoint = totalLength / 2;
        int i1 = 0, i2 = 0;

        if ((totalLength & 1) > 0) {
            while (i1 + i2 < midpoint) {
                if (i1 >= nums1.length || (i2 < nums2.length && nums1[i1] > nums2[i2])) i2++;
                else i1++;
            }
            if (i1 >= nums1.length || (i2 < nums2.length && nums1[i1] > nums2[i2])) return nums2[i2];
            return nums1[i1];
        }
        
        midpoint--;

        while (i1 + i2 < midpoint) {
            if (i1 >= nums1.length || (i2 < nums2.length && nums1[i1] > nums2[i2])) i2++;
            else i1++;
        }

        double median = 0;
        if (i1 >= nums1.length || (i2 < nums2.length && nums1[i1] > nums2[i2])) median += nums2[i2++];
        else median += nums1[i1++];

        if (i1 >= nums1.length || (i2 < nums2.length && nums1[i1] > nums2[i2])) median += nums2[i2];
        else median += nums1[i1];

        return median / 2.0;
    }
}
