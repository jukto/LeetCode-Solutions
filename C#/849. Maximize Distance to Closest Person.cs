// Problem: https://leetcode.com/problems/maximize-distance-to-closest-person/

public class Solution {
    public int MaxDistToClosest(int[] seats) {
        int gap = 0, i = 0;

        while (i < seats.Length && seats[i] == 0) { i++; }

        int max = i * 2;

        while (i < seats.Length) {
            if (seats[i] == 1) {
                max = Math.Max(max, gap);
                gap = 0;
            } else {
                gap++;
            }
            i++;
        }

        max = Math.Max(max, gap * 2);

        return (int)Math.Ceiling(max / 2.0);
    }
}
