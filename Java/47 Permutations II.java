//  Problem: https://leetcode.com/problems/permutations-ii/description/

class Solution {
    // An arbitrary value outside the possible range of nums[i]
    private static final int USED = 100;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        return recursion(new ArrayList<List<Integer>>(), nums, new Integer[nums.length], 0);
    }

    private List<List<Integer>> recursion(List<List<Integer>> result, int[] nums, Integer[] perm, int permLength) {
        if (permLength == nums.length) result.add( Arrays.asList(Arrays.copyOf(perm, permLength)) );
        else {
            // For each value in nums, check if its already used. If not, mark it and add it to permutation. Then backtrack.
            // (nums has a maximum length of 8, so marking it like this is faster than using a HashSet)
            for (int i = 0; i < nums.length; i++) {
                int val = nums[i];
                if (val != USED) {
                    perm[permLength] = val;
                    nums[i] = USED;
                    recursion(result, nums, perm, permLength + 1);
                    nums[i] = val;

                    // skip identical values
                    while (i + 1< nums.length && nums[i + 1] == val) i++;
                }
            }
        }
        return result;
    }
}
