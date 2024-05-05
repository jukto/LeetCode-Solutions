class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length, result = Integer.MAX_VALUE, queueStart = 0, queueEnd = 1;
        long[] prefix = new long[n + 1];
        int[] index = new int[n + 1];
        long sum = 0;

        index[0] = -1;

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            while (queueStart < queueEnd && prefix[queueStart] <= sum - k) {
                result = Integer.min(result, i - index[queueStart++]);
            }

            while (queueStart < queueEnd && prefix[queueEnd - 1] >= sum) {
                queueEnd--;
            }

            prefix[queueEnd] = sum;
            index[queueEnd] = i;
            queueEnd++;
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
