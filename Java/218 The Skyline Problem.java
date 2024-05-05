//  Problem: https://leetcode.com/problems/the-skyline-problem

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        var heightHeap = new PriorityQueue<int[]>((a, b) -> Integer.compare(b[2], a[2]));
        var rightQueue = new PriorityQueue<Integer>();
        var result = new ArrayList<List<Integer>>();
        int point, height, lastHeight = 0, i = 0;

        while (i < buildings.length) {
            point = buildings[i][0];

            lastHeight = trim(result, heightHeap, rightQueue, point, lastHeight);

            while (!heightHeap.isEmpty() && heightHeap.peek()[1] <= point) heightHeap.poll();

            while (i < buildings.length && buildings[i][0] == point) {
                rightQueue.add(buildings[i][1]);
                heightHeap.add(buildings[i++]);
            }

            if ((height = heightHeap.peek()[2]) != lastHeight) {
                result.add(List.of(point, height));
                lastHeight = height;
            }
        }

        trim(result, heightHeap, rightQueue, Long.MAX_VALUE, lastHeight);

        return result;
    }

    int trim(List<List<Integer>> result, PriorityQueue<int[]> heightHeap, PriorityQueue<Integer> rightQueue, long max, int lastHeight) {
        int point, height;

        while (!rightQueue.isEmpty() && rightQueue.peek() < max) {
            point = rightQueue.poll();
            
            while (!rightQueue.isEmpty() && rightQueue.peek() == point) rightQueue.poll();
            while (!heightHeap.isEmpty() && heightHeap.peek()[1] <= point) heightHeap.poll();

            if ((height = heightHeap.isEmpty() ? 0 : heightHeap.peek()[2]) != lastHeight) {
                result.add( List.of(point, height) );
                lastHeight = height;
            }
        }

        return lastHeight;
    }
}
