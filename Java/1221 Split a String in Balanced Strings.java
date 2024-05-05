class Solution {
    public int balancedStringSplit(String s) {
        int substrings = 0, balance = 0;

        for (char c : s.toCharArray()) {
            if (c == 'L') balance++;
            else balance--;

            if (balance == 0) {
                substrings++;
            }
        }
        
        return substrings;
    }
}
