//  Problem: https://leetcode.com/problems/minimum-penalty-for-a-shop/

class Solution {
    public int bestClosingTime(String customers) {
        char[] arr = customers.toCharArray();
        int n = arr.length, score = 0, best = -1, max = 0;

        // Since we don't care about the penalty itself, only its index, we can find
        // the same result by maximizing the inverse of the penalty--the arbitrarily-named "score".
        // Doing it this way allows us to process in a single loop.
        for (int i = 0; i < n; i++) {
            score += (arr[i] == 'Y') ? 1 : -1;

            if (score > max) {
                max = score;
                best = i;
            }
        }

        return best + 1;
    }
}
