//  Problem: https://leetcode.com/problems/maximal-network-rank/

class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        boolean[][] roadBetween = new boolean[n][n];
        int cityRank[] = new int[n], result = 0;

        // Count the number of roads to each city and mark the cities with a road between them.
        for (var road : roads) {
            int c1 = road[0], c2 = road[1];

            cityRank[c1]++;
            cityRank[c2]++;

            roadBetween[c1][c2] = true;
            roadBetween[c2][c1] = true;
        }

        // Find the maximum combined rank for each pair of cities.
        // If the cities share a road, only count it once.
        for (int i = 0; i < n; i++) {
            for (int k = i + 1; k < n; k++) {
                int rank = cityRank[i] + cityRank[k];
                if (roadBetween[i][k]) rank--;
                
                if (rank > result) result = rank;
            }
        }

        return result;
    }


}
