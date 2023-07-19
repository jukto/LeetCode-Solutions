class Solution {
    public int findKthNumber(int n, int k) {
        long result = 1;

        while (k > 1) {
            long jump = nextJump(n, result);
            if (jump < k) {
                k -= jump;
                result++;
            } else {
                result *= 10;
                k--;
            }
        }

        return (int)result;
    }

    private long nextJump(int n, long a) {
        long jump = 0, b = a + 1;
        while (a <= n) {
            jump += Math.min(n + 1, b) - a;
            a *= 10;
            b *= 10;
        }
        return jump;
    }
}
