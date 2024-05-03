// Problem: https://leetcode.com/problems/calculate-money-in-leetcode-bank/

public class Solution {
    public int TotalMoney(int n) {
        int weeks = n / 7, rem = n % 7;
        return 28 * weeks + 7 * (weeks - 1) * weeks / 2 + rem * (rem + 1) / 2 + weeks * rem;
    }
}
