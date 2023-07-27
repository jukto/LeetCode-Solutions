class Solution {
    public long maxRunTime(int n, int[] batteries) {
        // The maximum *potential* runtime is achieved when the total power is divided equally among the computers.
        long totalBattery = 0;
        for (int b : batteries) totalBattery += b;

        // Binary search over the possible runtimes to find the highest one that works.
        long left = 1, right = totalBattery / n, mid, result = 0;
        while (left <= right) {
            mid = (left + right) / 2;

            if (canRun(mid, batteries, n)) {
                left = mid + 1;
                result = mid;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    /**
        Find the maximum possible runtime provided by [batteries], assuming that each battery can provide a maximum
        of [time], and then check if that is enough to run [n] computers for that long.
    **/
    private boolean canRun(long time, int[] batteries, int n) {
        long runTime = 0;

        // Each battery can only provide a maximum of [time] runtime, so any value above that gets clamped.
        for (int batt : batteries)
            runTime += Long.min(time, batt);

        return runTime >= n * time;
    }
}
