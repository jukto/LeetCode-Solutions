// Problem: https://leetcode.com/problems/add-digits/

public class Solution {
    public int AddDigits(int num) {
        if (num == 0) {
            return 0;
        }
        int result = num % 9;
        return result == 0 ? 9 : result;
    }
}
