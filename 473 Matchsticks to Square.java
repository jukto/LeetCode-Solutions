//  Problem: https://leetcode.com/problems/matchsticks-to-square/description/

class Solution {
    public boolean makesquare(int[] matchsticks) {
        long target = 0;
        int sides = 4;

        // the target value for each side is the total length of all matchsticks / 4
        // if the total is not divisible by 4, return false
        for (int m : matchsticks) target += m;
        if (target % 4 != 0) return false;
        target /= 4;

        // if any matchstick is longer than the target, return false
        // if it is equal to target, then it is one of the sides by itself
        // otherwise add it to a list and sort in descending order
        List<Integer> matches = new ArrayList<Integer>();
        for (int m : matchsticks) {
            if (m > target) return false;
            if (m == target) sides--;
            else matches.add(m);
        }
        matches.sort(Collections.reverseOrder());

        return recursion(matches, new boolean[matches.size()], 0, target, 0, sides);
    }

    private boolean recursion(List<Integer> matches, boolean[] used, int index, long target, long sum, int sides) {
        // if at least three sides have been filled then the answer is true, since we know the total is divisible by 4
        if (sides <= 1) return true;

        // for each unique, unused match, try to add it to or use it to complete the current side
        for (int i = index; i < matches.size(); i++) {
            if (!used[i]) {
                long n = sum + matches.get(i);
                used[i] = true;

                if (n < target) {
                    if (recursion(matches, used, i + 1, target, n, sides))
                        return true;
                } else if (n == target) {
                    if (recursion(matches, used, 0, target, 0, sides - 1))
                        return true;
                }

                used[i] = false;
                if (sum == 0) return false;

                while (i < matches.size() - 1 && matches.get(i) == matches.get(i + 1)) i++;
            }
        }
        return false;
    }
}
