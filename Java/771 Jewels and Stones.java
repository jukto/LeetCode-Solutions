class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        boolean[] isJewel = new boolean[123];
        int result = 0;

        for (char c : jewels.toCharArray()) {
            isJewel[c] = true;
        }

        for (char c : stones.toCharArray()) {
            if (isJewel[c]) result++;
        }

        return result;
    }
}
