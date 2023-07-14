class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int[] up = null, down = null, right = null, left = null, upRight = null, downRight = null, upLeft = null, downLeft = null;

        for (int[] queen : queens) {
            if (queen[0] == king[0]) {
                if (queen[1] > king[1]) {
                    if (down == null || down[1] > queen[1]) {
                        down = queen;
                    }
                } else if (up == null || up[1] < queen[1]) {
                    up = queen;
                }
            } else if (queen[1] == king[1]) {
                if (queen[0] > king[0]) {
                    if (right == null || right[0] > queen[0]) {
                        right = queen;
                    }
                } else if (left == null || left[0] < queen[0]) {
                    left = queen;
                }
            } else if (Math.abs(king[0] - queen[0]) == Math.abs(king[1] - queen[1])) {
                if (queen[0] > king[0]) {
                    if (queen[1] > king[1]) {
                        if (upRight == null || upRight[1] > queen[1]) {
                            upRight = queen;
                        }
                    } else if (upLeft == null || upLeft[1] < queen[1]) {
                        upLeft = queen;
                    }
                } else if (queen[1] > king[1]) {
                    if (downRight == null || downRight[1] > queen[1]) {
                        downRight = queen;
                    }
                } else if (downLeft == null || downLeft[1] < queen[1]) {
                    downLeft = queen;
                }
            }
        }

        var result = new ArrayList<List<Integer>>();

        if (down != null) {
            result.add(List.of(down[0], down[1]));
        }
        if (up != null) {
            result.add(List.of(up[0], up[1]));
        }
        if (left != null) {
            result.add(List.of(left[0], left[1]));
        }
        if (right != null) {
            result.add(List.of(right[0], right[1]));
        }
        if (upLeft != null) {
            result.add(List.of(upLeft[0], upLeft[1]));
        }
        if (upRight != null) {
            result.add(List.of(upRight[0], upRight[1]));
        }
        if (downLeft != null) {
            result.add(List.of(downLeft[0], downLeft[1]));
        }
        if (downRight != null) {
            result.add(List.of(downRight[0], downRight[1]));
        }

        return result;
    }
}
