class Solution {
    public double myPow(double x, int n) {
        if (n < 0) return 1.0 / positivePower(x, -(long)n);
        return positivePower(x, n);
    }

    private double positivePower(double x, long n) {
        if (n == 0) return 1;
        if (n % 2 == 0) return positivePower(x * x, n / 2);
        return x * positivePower(x * x, (n - 1) / 2);
    }
}
