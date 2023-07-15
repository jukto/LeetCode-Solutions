class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.parallelSort(events, new startComparator());
        return recursion(events, new int[events.length * k], k, 0, 0);
    }

    private int recursion(int[][] events, int[] cache, int k, int index, int eventsTaken) {
        int key = (eventsTaken * events.length) + index;
        if (cache[key] > 0) return cache[key] - 1;

        int result = 0, takeSum = events[index][2];

        if (index + 1 < events.length) {
            result = recursion(events, cache, k, index + 1, eventsTaken);
        }

        eventsTaken++;
        if (eventsTaken < k) {
            index = binarySearch(events, index + 1, events[index][1]);
            if (index > 0) {
                takeSum += recursion(events, cache, k, index, eventsTaken);
            }
        }

        if (takeSum > result) {
            result = takeSum;
        }

        cache[key] = result + 1;
        return result;
    }

    private int binarySearch(int[][] events, int start, int day) {
        int left = start, right = events.length - 1, req = -1;

        while (left <= right) {
            int mid = ((right - left) / 2) + left;

            if (events[mid][0] > day) {
                req = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return req;
    }

    private class startComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            return a[0] - b[0];
        }
    }
}
