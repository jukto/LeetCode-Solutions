class Solution {
    private static final int[] powersOfTen = new int[] { 1, 10, 100, 1_000, 10_000, 100_000, 1_000_000, 10_000_000, 100_000_000, 1_000_000_000 };

    public int monotoneIncreasingDigits(int n) {
        if (n < 10) return n;

        for (int i = 0; i < 9; i++) {
            if(getDigit(n, i + 1) > getDigit(n, i)) {
                n -= (n % powersOfTen[i]) + 1;
                i--;
            }
        }

        return n;
    }

    private static int getDigit(int num, int digit) {
        return (num / powersOfTen[digit]) % 10;
    }
}
