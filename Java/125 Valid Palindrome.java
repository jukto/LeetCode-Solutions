class Solution {
    public boolean isPalindrome(String s) {
        char[] sArray = s.toCharArray();
        int i = 0, k = sArray.length - 1;

        while (i < k) {
            while (i < k && !Character.isLetterOrDigit(sArray[i])) i++;
            while (i < k && !Character.isLetterOrDigit(sArray[k])) k--;

            if (Character.toLowerCase(sArray[i]) != Character.toLowerCase(sArray[k])) return false;

            i++;
            k--;
        }

        return true;
    }
}
