// Problem: https://leetcode.com/problems/relative-sort-array/

public class Solution {
    public int[] RelativeSortArray(int[] arr1, int[] arr2) {
        Array.Sort(arr1, new RelativeComparer(arr2));
        return arr1;
    }

    private class RelativeComparer : IComparer<int> {
        private int[] array;

        public RelativeComparer(int[] arr2) {
            array = new int[1001];
            for (int i = 0; i < 1001; i++) {
                array[i] = i + 1001;
            }
            for (int i = 0; i < arr2.Length; i++) {
                array[arr2[i]] = i;
            }
        }

        public int Compare(int x, int y) {
            return array[x].CompareTo(array[y]);
        }
    }
}
