//  Problem: https://leetcode.com/problems/frog-jump/

class Solution {
    public boolean canCross(int[] stones) {
        // Due to the constraints that stones[0] is always 0 and the first jump must be of distance 1,
        // it is automatically impossible to cross any stones where stones[1] is not 1.
        if (stones[1] != 1) { return false; }

        int n = stones.length;
        Map<Integer, Integer> stoneMap = new HashMap<>(n);
        for (int i = 0; i < n; i++) { stoneMap.put(stones[i], i); }

        return recursion(stones, 1, 1, 0, new boolean[n][n], stoneMap);
    }

    /**
        Memoized DPS
        The memoization array is indexed by the indexes of the last stone and the current stone. It would also be possible to index it
        by current stone and k, but due to k's potentially high value, this would require memo be a more expensive datatype.
        Because the function returns immediately whenever a correct path is found, we only need to memoize the points where reaching the end is impossible.
    */
    boolean recursion(int[] stones, int stone, int k, int last, boolean[][] memo, Map<Integer, Integer> stoneMap) {
        Integer current = stoneMap.get(stone);

        if (current == null || memo[current][last]) { return false; }
        if (current == stones.length - 1) { return true; }

        // k is the distance of the last jump we made, our next jump can be anything in the range [k - 1:k + 1].
        // A jump of length 0 would result in an infinite loop though, so only check k - 1 when k > 1.
        if (
            recursion(stones, (stone += k) + 1, k + 1, current, memo, stoneMap)
            || recursion(stones, stone, k, current, memo, stoneMap)
            || (k > 1 && recursion(stones, stone - 1, k - 1, current, memo, stoneMap))
        ) { return true; }

        memo[current][last] = true;
        return false;
    }
}
