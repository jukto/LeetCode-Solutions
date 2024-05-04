// Problem: https://leetcode.com/problems/boats-to-save-people/

public class Solution {
    public int NumRescueBoats(int[] people, int limit) {
        int result = 0, left = 0, right = people.Length - 1;
        Array.Sort(people);

        while (left <= right) {
            if (people[right] + people[left] <= limit) {
                left++;
            }
            right--;
            result++;
        }

        return result;
    }
}
