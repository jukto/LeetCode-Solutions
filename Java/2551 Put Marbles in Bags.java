class Solution {
    public long putMarbles(int[] weights, int k) {
        int[] potentialBags = new int[weights.length - 1];

        for (int i = 0; i < weights.length - 1; i++) {
            potentialBags[i] = weights[i] + weights[i + 1];
        }

        Arrays.sort(potentialBags);
        
        long min = 0, max = 0;

        for (int i = 0; i < k - 1; i++) {
            min += potentialBags[i];
            max += potentialBags[weights.length - i - 2];
        }

        return max - min;
    }
}
