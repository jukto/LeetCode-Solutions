class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length, result[] = new int[n], lastTemp = Integer.MAX_VALUE;
        Stack<Integer> mono = new Stack<Integer>();

        for (int i = 0; i < n; i++) {
            int temp = temperatures[i];
            while (lastTemp < temp) {
                lastTemp = mono.pop();
                result[lastTemp] = i - lastTemp;
                lastTemp = mono.isEmpty() ? Integer.MAX_VALUE : temperatures[mono.peek()];
            }
            mono.push(i);
            lastTemp = temp;
        }

        return result;
    }
}
