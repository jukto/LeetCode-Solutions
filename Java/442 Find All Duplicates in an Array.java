class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> result = new ArrayList<Integer>(nums.length);

        for (int num : nums) {
            int index = Math.abs(num) - 1;
            if (nums[index] < 0) {
                result.add(index + 1);
            } else {
                nums[index] *= -1;
            }
        }

        return result;
    }
}
