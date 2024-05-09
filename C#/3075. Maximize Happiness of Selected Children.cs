// Problem: https://leetcode.com/problems/maximize-happiness-of-selected-children/

public class Solution {
    public long MaximumHappinessSum(int[] happiness, int k) {
        int left = 0, right = k, n = happiness.Length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (Check(happiness, mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        QuickSort(happiness, 0, n - 1, n - left);
        
        long result = -(long)left * (left - 1) / 2;

        for (int i = n - 1; left-- > 0; i--) {
            result += happiness[i];
        }

        return result;
    }

    // Check if there are at least mid values in happiness greater than mid
    public bool Check(int[] happiness, int mid) {
        int count = 0;

        foreach (int x in happiness) {
            if (x > mid && ++count > mid) {
               return true;
            }
        }

        return false;
    }

    public void QuickSort(int[] nums, int low, int high, int k) {
        if (low >= high) {
            return;
        }

        int left = low - 1, right = high + 1, mid = low + (high - low) / 2, x = nums[mid];

        while (left < right) {
            while (nums[++left] < x) { }
            while (nums[--right] > x) { }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }

        if (right < k) {
            QuickSort(nums, right + 1, high, k);
        } else {
            QuickSort(nums, low, right, k);
        }
    }
}
