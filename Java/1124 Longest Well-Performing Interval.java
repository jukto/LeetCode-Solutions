class Solution {
    private static final int CACHE_SIZE = 8000, CACHE_OFFSET = CACHE_SIZE / 2;

    public int longestWPI(int[] hours) {
        int[] prefix = new int[hours.length], cache = new int[CACHE_SIZE];
        int maxLength = 0;

        if (hours[0] > 8) {
            prefix[0] = 1;
            cache[CACHE_OFFSET + 1] = 1;
            maxLength = 1;
        } else {
            prefix[0] = -1;
            cache[CACHE_OFFSET - 1] = 1;
        }

        for (int i = 1; i < hours.length; i++) {
            prefix[i] = (hours[i] > 8) ? prefix[i - 1] + 1 : prefix[i - 1] - 1;
            if (prefix[i] > 0) {
                maxLength = i + 1;
            }
            if (cache[prefix[i] + CACHE_OFFSET] == 0) {
                cache[prefix[i] + CACHE_OFFSET] = i + 1;
            }
        }

        if (maxLength == hours.length)
            return maxLength;

        for (int i = 1; i < hours.length; i++) {
            int k = cache[prefix[i] + CACHE_OFFSET - 1] - 1;
            if (k >= 0 && i - k > maxLength) {
                maxLength = i - k;
            }
        }

        return maxLength;
    }
}
