class Solution {
    public boolean hasAlternatingBits(int n) {
        int lastBit = -1, bit;

        while (n > 0) {
            if ((bit = (n & 1)) == lastBit)
                return false;
            lastBit = bit;
            n >>= 1;
        }

        return true;
    }
}
