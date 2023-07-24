class Solution {
    private static final int MOD = 1337, COPRIMES = 1140;

    public int superPow(int a, int[] b) {
        int exponent = 0;
        
        for (int digit : b) {
            exponent = ((exponent * 10) + digit) % COPRIMES;
        }

        return (int)pow(a % MOD, exponent);
    }

    private long pow(long a, long b) {
        if (b == 0) return 1;
        if (b % 2 == 0) return pow((a * a) % MOD, b / 2);
        return (a * pow((a * a) % MOD, (b - 1) / 2)) % MOD;
    }
}
