class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueToIndex = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            Integer i2 = valueToIndex.get(need);
            if (i2 != null) {
                return new int[] {i, i2};
            }
            valueToIndex.put(nums[i], i);
        }
        return null;
    }
}
