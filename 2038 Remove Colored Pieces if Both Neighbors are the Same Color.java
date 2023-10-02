//  Problem: https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/

class Solution {
    public boolean winnerOfGame(String colors) {
        int score = 0, streak = 0;
        char last = 0;

        for (var c : colors.toCharArray()) {
            if (c != last) {
                if (streak > 2) {
                    if (last == 'A') score += streak - 2;
                    else score -= streak - 2;
                }
                last = c;
                streak = 1;
            } else streak++;
        }
        if (streak > 2) {
            if (last == 'A') score += streak - 2;
            else score -= streak - 2;
        }

        return score > 0;
    }
}
