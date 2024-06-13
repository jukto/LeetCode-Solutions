// Problem: https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/

public class Solution {
    public int MinMovesToSeat(int[] seats, int[] students) {
        var result = 0;

        Array.Sort(seats);
        Array.Sort(students);

        for (var i = 0; i < seats.Length; i++) {
            result += Math.Abs(seats[i] - students[i]);
        }
        
        return result;
    }
}
