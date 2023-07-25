class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 1, right = arr.length - 1, mid;

        while (true) {
            mid = (left + right) / 2;

            if (arr[mid] > arr[mid + 1]) {
                if (arr[mid - 1] < arr[mid]) return mid;
                right = mid - 1;
            } else left = mid + 1;
        }
    }
}
