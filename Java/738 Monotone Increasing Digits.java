class Solution {
    private static final int[] powersOfTen = new int[] { 1, 10, 100, 1_000, 10_000, 100_000, 1_000_000, 10_000_000, 100_000_000, 1_000_000_000 };

    public int monotoneIncreasingDigits(int n) {
        for (int i = 0; i < 9; i++) {
            while ((n / powersOfTen[i + 1]) % 10 > (n / powersOfTen[i]) % 10) {
                n -= (n % powersOfTen[i]) + 1;
            }
        }

        return n;
    }
}
