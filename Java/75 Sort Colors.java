class Solution {
    public void sortColors(int[] nums) {
        int sorted = 0, blues = 0, whites = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[sorted++] = nums[i];
            } else if (nums[i] == 1) {
                whites++;
            } else {
                blues++;
            }
        }

        while (whites > 0) {
            nums[sorted++] = 1;
            whites--;
        }

        while (blues > 0) {
            nums[sorted++] = 2;
            blues--;
        }
    }
}
