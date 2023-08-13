//  Problem: https://leetcode.com/problems/task-scheduler-ii

class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        Map<Integer, Long> ready = new HashMap<>();
        long day = 0;
        
        // For each task, check if it can be done yet or wait until it can,
        // then record the next day this type of task can be completed.
        for (int task : tasks) {
            day = Math.max(day, ready.getOrDefault(task, 0l)) + 1l;
            ready.put(task, day + space);
        }

        return day;
    }
}
