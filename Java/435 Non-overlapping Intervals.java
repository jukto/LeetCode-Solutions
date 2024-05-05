class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, EndComparator.singleton);
        int end = intervals[0][1], count = -1;

        for (int[] interval : intervals) {
            if (interval[0] >= end) {
                end = interval[1];
            } else {
                count++;
            }
        }

        return count;
    }

    private static class EndComparator implements Comparator<int[]> {
        public static EndComparator singleton = new EndComparator();
        
        @Override
        public int compare(int[] a, int[] b) {
            return a[1] - b[1];
        }
    }
}
