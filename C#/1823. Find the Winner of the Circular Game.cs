// Problem: https://leetcode.com/problems/find-the-winner-of-the-circular-game/

public class Solution {
    public int FindTheWinner(int n, int k) {
        var result = 0;

        for (int i = 1; i <= n; i++)
            result = (result + k) % i;

        return result + 1;
    }
}
