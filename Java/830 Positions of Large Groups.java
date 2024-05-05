//  Problem: https://leetcode.com/problems/positions-of-large-groups/description/

class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        int start = 0, i = 0;
        char last = 0;

        for (char c : s.toCharArray()) {
            if (c != last) {
                if (i - start >= 3)
                    result.add(List.of(start, i - 1));
                last = c;
                start = i;
            }
            i++;
        }

        if (i - start >= 3)
            result.add(List.of(start, i - 1));

        return result;
    }
}
