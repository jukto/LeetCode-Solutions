class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int max = Integer.MIN_VALUE, n = intervals.length;
        HashMap<Integer, Integer> map = new HashMap<>(n);
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            if (start > max) { max = start; }
            map.put(start, i);
        }

        for (int i = 0; i < n; i++) {
            int k = intervals[i][1];
            if (k > max) {
                result[i] = -1;
            } else {
                while (!map.containsKey(k)) { k++; }
                result[i] = map.get(k);
            }
        }

        return result;
    }
}
