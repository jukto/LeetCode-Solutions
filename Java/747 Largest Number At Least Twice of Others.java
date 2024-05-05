class Solution {
    public int dominantIndex(int[] nums) {
        if (nums.length < 2) return -1;

        int largest = -1, index = -1, second = -1;

        for (int i = 0; i< nums.length; i++) {
            int num = nums[i];

            if (num >= largest) {
                second = largest;
                largest = num;
                index = i;
            } else if (num > second) {
                second = num;
            }
        }

        return (largest >= second * 2) ? index : -1;
    }
}
