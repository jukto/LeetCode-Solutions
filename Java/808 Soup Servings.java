//  Problem: https://leetcode.com/problems/soup-servings/description/

class Solution {
    private double[] cache = new double[26407];

    public double soupServings(int n) {
        // From pre-processing: 4051 is the lowest value of n where the result rounds up to 0.99998
        // Therefore anything at or above that is within the 10^-5 error margin of 0.99999
        if (n > 4050) return 0.99999;

        // dividing n by the gcd of the operations reduces the range of possible a/b combinations enough that we can
        // use an array of doubles instead of a HashMap as our memoization cache.
        n = (int)Math.ceil(n / 25.0);

        return recursion(n, n);
    }

    private double recursion(int a, int b) {
        if (a <= 0) {
            if (b <= 0) return 0.5;
            return 1.0;
        }
        if (b <= 0) return 0.0;

        int key = a * 162 + b;
        
        if (cache[key] != 0) {
            return cache[key];
        }

        double result = recursion(a - 4, b);
        result += recursion(a - 3, b - 1);
        result += recursion(a - 2, b - 2);
        result += recursion(a - 1, b - 3);

        result /= 4.0;
        
        return cache[key] = result;
    }

    private void preprocessing() {
        int n = 5_000;
        while (recursion(n, n) >= 0.999975) {
            n--;
        }
        System.out.println(n + 1);
    }
}
