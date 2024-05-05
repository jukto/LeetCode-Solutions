class Solution {
    private static Map<String, Boolean> cache = new HashMap<String, Boolean>();

    public String longestPalindrome(String s) {
        int left = 0, maxLeft = 0, maxRight = 0;
        
        for(int i = 1; i < s.length(); i++) {
            if (left > 0 && s.charAt(left - 1) == s.charAt(i)) {
                left--;
            } else if (!allAre(s, left, i)) {
                while (!isPalindrome(s.substring(left, i + 1))) {
                    left++;
                }
            }

            if (i - left > maxRight - maxLeft) {
                maxRight = i;
                maxLeft = left;
            }
        }

        return s.substring(maxLeft, maxRight + 1);
    }

    private boolean allAre(String s, int left, int right) {
        char c = s.charAt(right);
        for (int i = left; i < right; i++) {
            if (s.charAt(i) != c) return false;
        }
        return true;
    }

    private boolean isPalindrome(String s) {
        if (s.length() <= 1) return true;
        if (cache.containsKey(s)) return cache.get(s);

        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            cache.put(s, isPalindrome(s.substring(1, s.length() - 1)));
            return cache.get(s);
        }
        cache.put(s, false);
        return false;
    }
}
