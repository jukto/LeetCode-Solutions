class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int result = 0, distance = 1000000, tempDistance = 0;
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1;
            int sum = nums[i] + nums[j] + nums[k];

            if (target > sum) tempDistance = target - sum;
            else if (sum > target) tempDistance = sum - target;
            else return target;

            if (tempDistance < distance) {
                result = sum;
                distance = tempDistance;
            }

            while (true) {
                if (sum < target && j + 1 < k) j++;
                else if (sum > target && k - 1 > j) k--;
                else {
                    if (target > sum) tempDistance = target - sum;
                    else if (sum > target) tempDistance = sum - target;
                    else return target;

                    if (tempDistance < distance) {
                        result = sum;
                        distance = tempDistance;
                    }
                    break;
                }
                sum = nums[i] + nums[j] + nums[k];
            }
            
            while (i + 3 < nums.length && nums[i] == nums[i + 1]) i++;
        }

        return result;
    }
}
