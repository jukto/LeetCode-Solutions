//  Problem: https://leetcode.com/problems/check-if-all-as-appears-before-all-bs/submissions/

class Solution {
    public boolean checkString(String s) {
        boolean bHasAppeared = false;

        // If the character is 'a' and we've seen a 'b' appear before now, return false;
        for (char c : s.toCharArray()) {
            if (c == 'b') bHasAppeared = true;
            else if (bHasAppeared) return false;
        }

        return true;
    }
}
