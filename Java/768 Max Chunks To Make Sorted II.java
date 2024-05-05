//  Problem: https://leetcode.com/problems/max-chunks-to-make-sorted-ii/description/

class Solution {
    public int maxChunksToSorted(int[] arr) {
        int chunks = 0, n = arr.length, i = 0, max;
        int[] min = new int[n];

        // set each min[i] to the minimum value in arr[i:]
        min[n - 1] = arr[n - 1];
        for (int j = n - 2; j > 0; j--)
            min[j] = Integer.min(min[j + 1], arr[j]);

        // Add a new chunk. For as long as the greatest value in the chunk is greater than
        // the minimum value to the right of it, continue to expand the chunk. Repeat until
        // all values have been put into a chunk.
        while (i < n) {
            chunks++;
            max = arr[i++];
            while (i < n && max > min[i])
                max = Integer.max(max, arr[i++]);
        }
        
        return chunks;
    }
}
