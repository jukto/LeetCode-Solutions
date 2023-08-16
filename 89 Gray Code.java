//  Problem: https://leetcode.com/problems/gray-code/

class Solution {
    public List<Integer> grayCode(int n) {
        int[] running = new int[1 << n];
        int length = 1;

        // One possible grey code can be expressed as a pattern where
        // the first element is zero, and each new 2^x elements is equal
        // to the preceding 2^x elements in reverse order plus 2^x.
        while (length < running.length) {
            int bit = length;
            for (int i = length - 1; i >= 0; i--) {
                running[length++] = running[i] | bit;
            }
        }

        List<Integer> result = new ArrayList<>(running.length);
        for (var num : running) result.add(num);

        return result;
    }
}
