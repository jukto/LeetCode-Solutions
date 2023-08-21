//  Problem: https://leetcode.com/problems/reverse-vowels-of-a-string/

class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;

        // Find the leftmost and rightmost unswapped vowels and swap them.
        while (true) {
            while (!isVowel(arr[left]) && left < right) left++;
            while (!isVowel(arr[right]) && left < right) right--;

            if (left >= right) break;
            swap(arr, left++, right--);
        }

        return new String(arr);
    }

    boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
            || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
