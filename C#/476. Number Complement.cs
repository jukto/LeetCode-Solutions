// Problem: https://leetcode.com/problems/number-complement/

public class Solution {
    public int FindComplement(int num) {
        int hiBit = ((int)Math.Log(num, 2) + 1);
        int mask = (1 << hiBit) - 1;

        return num ^ mask;
    }
}
