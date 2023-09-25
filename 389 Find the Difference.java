//  Problem: https://leetcode.com/problems/find-the-difference/

class Solution {
    public char findTheDifference(String s, String t) {
        char ans = 0;

        for (char c : t.toCharArray()) { ans += c; }
        for (char c : s.toCharArray()) { ans -= c; }

        return ans;
    }
}
