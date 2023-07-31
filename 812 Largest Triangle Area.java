//  Problem: https://leetcode.com/problems/largest-triangle-area/description/

class Solution {
    public double largestTriangleArea(int[][] points) {
        int n = points.length, p1[], p2[];
        double squareArea = 0, comparison;

        // brute force through all combinations of 3 points to find the largest rectangular area
        for (int i = 0; i < n; i++) {
            p1 = points[i];
            for (int k = i + 1; k < n; k++) {
                p2 = points[k];
                for (int j = k + 1; j < n; j++) {
                    if ((comparison = findSquarea(p1, p2, points[j])) > squareArea)
                        squareArea = comparison;
                }
            }
        }

        // The triangular area is the rectangular area divided by 2.
        return squareArea / 2;
    }

    private double findSquarea(int[] p1, int[] p2, int[] p3) {
        return Math.abs( (p2[0] - p1[0]) * (p3[1] - p1[1]) - (p2[1] - p1[1]) * (p3[0] - p1[0]) );
    }
}
