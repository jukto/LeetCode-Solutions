class Solution {
    public int trap(int[] height) {
        int n = height.length, max = 0, total = 0;
        int[] right = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            right[i] = max;
            max = Integer.max(height[i], max);
        }

        max = 0;

        for (int i = 0; i < n; i++) {
            total += Integer.max(Integer.min(max, right[i]) - height[i], 0);
            max = Integer.max(height[i], max);
        }

        return total;
    }
}
