//  Problem: https://leetcode.com/problems/complement-of-base-10-integer/

class Solution {
    public int bitwiseComplement(int n) {
        int result = 0, bit = 1;

        do {
            if ((n & 1) == 0) result += bit;
            n >>= 1;
            bit <<= 1;
        } while (n > 0);

        return result;
    }
}
