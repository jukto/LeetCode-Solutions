//  Problem: https://leetcode.com/problems/replace-elements-in-an-array/description/

class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        int[] cache = new int[1_000_001];

        for (int i = 0; i < nums.length; i++)
            cache[nums[i]] = i;
        
        for (int[] op : operations) {
            cache[op[1]] = cache[op[0]];
            nums[cache[op[0]]] = op[1];
        }

        return nums;
    }

    // The more practical HashMap implementation:
    /**
        public int[] arrayChange(int[] nums, int[][] operations) {
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

            for (int i = 0; i < nums.length; i++)
                map.put(nums[i], i);

            for (int[] op : operations) {
                int index = map.get(op[0]);
                map.put(op[1], index);
                nums[index] = op[1];
            }

            return nums;
        }
    */
}
