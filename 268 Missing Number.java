class Solution {
    public int missingNumber(int[] nums) {
        boolean[] result = new boolean[nums.length + 1];

        for (int num : nums) {
            result[num] = true;
        }

        for (int i = 0; i < result.length; i++) {
            if (!result[i]) return i;
        }

        return nums.length;
    }
}
