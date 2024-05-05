class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, lisLength = 1, result = 1, minNum = nums[0];
        int[] lisDP = new int[n], countDP = new int[n];

        lisDP[0] = countDP[0] = 1;

        for (int i = 1; i < n; i++) {
            int localLIS = 0, localCount = 1, num = nums[i];
            
            if (minNum < num) {
                for (int k = i - 1; k >= 0; k--) {
                    if (nums[k] < num) {
                        if (lisDP[k] > localLIS) {
                            localLIS = lisDP[k];
                            localCount = countDP[k];
                        } else if (lisDP[k] == localLIS) {
                            localCount += countDP[k];
                        }
                    }
                }
            }

            if (num < minNum) minNum = num;

            lisDP[i] = ++localLIS;
            countDP[i] = localCount;
            
            if (localLIS > lisLength) {
                lisLength = localLIS;
                result = localCount;
            } else if (localLIS == lisLength) result += localCount;
        }
        return result;
    }
}
