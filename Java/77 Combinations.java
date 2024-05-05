//  Problem: https://leetcode.com/problems/combinations/description/

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        return recursion(new ArrayList<List<Integer>>(), n, k, 0, new Integer[k], 0);
    }

    private List<List<Integer>> recursion(List<List<Integer>> result, int n, int k, int last, Integer[] combo, int comboLength) {
        if (comboLength == k) result.add( Arrays.asList(Arrays.copyOf(combo, comboLength)) );
        else {
            // The next value we add must be greater than the last added value, and leave at least (k - length of combination) values after it.
            for (int i = n - k + comboLength + 1; i > last; i--) {
                combo[comboLength] = i;
                recursion(result, n, k, i, combo, comboLength + 1);
            }
        }
        return result;
    }
}
