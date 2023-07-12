class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        boolean[] visited = new boolean[graph.length], safe = new boolean[graph.length];
        List<Integer> result = new ArrayList<Integer>(graph.length);

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (graph[i].length == 0) {
                    visited[i] = true;
                    safe[i] = true;
                } else {
                    recursion(safe, graph, visited, i);
                }
            }
            if (safe[i]) {
                result.add(i);
            }
        }
        
        return result;
    }

    private void recursion(boolean[] safe, int[][] graph, boolean[] visited, int index) {
        visited[index] = true;

        for (int edge : graph[index]) {
            if (!visited[edge]) recursion(safe, graph, visited, edge);
        }
        
        for (int edge : graph[index]) {
            if (!safe[edge]) return;
        }

        safe[index] = true;
    }
}
