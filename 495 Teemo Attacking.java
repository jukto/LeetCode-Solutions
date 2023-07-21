class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int total = 0, i = 0;
        
        while (i < timeSeries.length) {
            int time = timeSeries[i], until = time + duration;

            while (++i < timeSeries.length && until > timeSeries[i])
                until = timeSeries[i] + duration;

            total += until - time;
        }

        return total;
    }
}
