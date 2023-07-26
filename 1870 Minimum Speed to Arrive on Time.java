class Solution {
    private static final int MAX_SPEED = 10_000_000;

    public int minSpeedOnTime(int[] dist, double hour) {
        if (hour < dist.length - 1) return -1;

        int n_ = dist.length - 1, result = -1;
        double mid, arrival, totalDistance = 0;

        for (int d : dist) {
            totalDistance += d;
        }

        int left = (int)(totalDistance / hour), right = (int)Math.ceil(Math.min(totalDistance / (hour - n_), MAX_SPEED));

        while (left <= right) {
            mid = (left + right) / 2;

            arrival = 0.0;
            for (int i = 0; i < n_; i++) {
                arrival += Math.ceil(dist[i] / mid);
            }
            arrival += dist[n_] / mid;

            if (arrival > hour) {
                left = (int)mid + 1;
            } else {
                result = (int)mid;
                right = result - 1;
            }
        }

        return result;
    }
}
