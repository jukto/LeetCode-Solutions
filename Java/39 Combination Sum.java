// Problem: https://leetcode.com/problems/combination-sum/description/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return recursion(new ArrayList<List<Integer>>(), candidates, new Integer[20], 0, target, 0);
    }

    private List<List<Integer>> recursion(List<List<Integer>> result, int[] candidates, Integer[] combo, int comboLength, int target, int index) {
        if (target <= 0) {
            if (target == 0) result.add( Arrays.asList(Arrays.copyOf(combo, comboLength)) );
            return result;
        }

        for (int i = index; i < candidates.length; i++) {
            combo[comboLength] = candidates[i];
            recursion(result, candidates, combo, comboLength + 1, target - candidates[i], i);
        }
        return result;
    }
}
