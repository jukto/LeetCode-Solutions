class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueToIndex = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            Integer vv = valueToIndex.get(need);
            if (vv != null) {
                return new int[] {i, valueToIndex.get(need)};
            }
            valueToIndex.put(nums[i], i);
        }
        return nums;
    }
}
