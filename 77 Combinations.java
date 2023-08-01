//  Problem: https://leetcode.com/problems/combinations/description/

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        return recursion(new ArrayList<List<Integer>>(), n, k, 0, new int[20], 0);
    }

    private List<List<Integer>> recursion(List<List<Integer>> result, int n, int k, int last, int[] combo, int comboLength) {
        if (comboLength == k) result.add( makeList(combo, comboLength) );
        else {
            // The next value we add must be greater than the last added value, and leave at least (k - length of combination) values after it.
            for (int i = n - k + comboLength + 1; i > last; i--) {
                combo[comboLength] = i;
                recursion(result, n, k, i, combo, comboLength + 1);
            }
        }
        return result;
    }

    // Since k has a maximum value of 20, we can use an array and a pointer to keep track of the current combination instead of a list.
    // This helper function converts that into the List<Integer> that we are expected to return.
    private List<Integer> makeList(int[] array, int arrayLength) {
        List<Integer> list = new ArrayList<Integer>(arrayLength);
        for (int i = 0; i < arrayLength; i++)
            list.add(array[i]);
        return list;
    }
}
