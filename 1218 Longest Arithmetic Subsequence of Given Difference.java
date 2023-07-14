class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int[] array = new int[40000];
        int max = 1;

        for (int num : arr) {
            int length = array[num - difference + 20000] + 1;
            array[num + 20000] = length;
            if (length > max) { max = length; }
        }

        return max;
    }
}
