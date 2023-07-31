// Problem: https://leetcode.com/problems/combination-sum/description/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return recursion(new ArrayList<List<Integer>>(), candidates, new int[20], 0, target, 0);
    }

    private List<List<Integer>> recursion(List<List<Integer>> result, int[] candidates, int[] combination, int endex, int target, int index) {
        if (target <= 0) {
            if (target == 0)
                result.add( makeList(combination, endex) );
            return result;
        }

        for (int i = index; i < candidates.length; i++) {
            combination[endex] = candidates[i];
            recursion(result, candidates, combination, endex + 1, target - candidates[i], i);
        }
        return result;
    }

    // Since candidates[i] has a minimum value of 2 and target has a maximum of 40, no combination will ever have more
    // than 20 members. So we can use an array and a pointer to keep track of the current combination instead of a list.
    private List<Integer> makeList(int[] array, int endex) {
        var result = new ArrayList<Integer>(endex);
        for (int i = 0; i < endex; i++)
            result.add(array[i]);
        return result;
    }
}
