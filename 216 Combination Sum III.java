//  Problem: https://leetcode.com/problems/combination-sum-iii

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        return dps(new ArrayList<List<Integer>>(), k, n, 0, new int[9], 0);
    }

    // Straightforward dps with backtracking that tries each unique combination of 1-9 of length k in lexographical order.
    List<List<Integer>> dps(List<List<Integer>> result, int k, int n, int i, int[] running, int length) {
        if (n == 0 && length == k) {
            result.add( toList(running, length) );
            
        } else if (n > 0 && length < k ) {

            while (++i <= 9) {
                running[length] = i;
                dps(result, k, n - i, i, running, length + 1);
            }

        }
        return result;
    }

    List<Integer> toList(int[] array, int length) {
        List<Integer> result = new ArrayList<>(length);
        for (int i = 0; i < length; i++) result.add(array[i]);
        return result;
    }
}
