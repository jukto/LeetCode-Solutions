class Solution {
    public int findDuplicate(int[] nums) {
        return version2(nums);
    }

    // Uses constant extra space and does not modify nums
    private int version1(int[] nums) {
        int n = nums.length, left = 0, right = n, mid, above, below, count;
        boolean seen;

        while (true) {
            above = below = 0;
            seen = false;
            mid = (left + right) / 2;

            for (int num : nums) {
                if (num > mid) above++;
                else if (num < mid) below++;
                else {
                    if (seen) return mid;
                    seen = true;
                }
            }

            if (above >= n - mid) left = mid + 1;
            else right = mid;
        }
    }

    // O(n) time
    private int version2(int[] nums) {
        boolean[] seen = new boolean[nums.length + 1];

        for (int num : nums) {
            if (seen[num]) return num;
            seen[num] = true;
        }

        return -1;
    }
}
