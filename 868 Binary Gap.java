class Solution {
    public int binaryGap(int n) {
        int maxDistance = 0, lastIndex = 32;
        
        for (int i = 0; i < 31; i++) {
            if ((n & 1) == 1) {
                if (i - lastIndex > maxDistance) maxDistance = i - lastIndex;
                lastIndex = i;
            }
            n /= 2;
        }

        return maxDistance;
    }
}
