// Problem: https://leetcode.com/problems/sum-of-distances-in-tree/

public class Solution {

    public int[] SumOfDistancesInTree(int n, int[][] edges) {
        int[] count = new int[n], dis = new int[n];
        var adj = new List<int>[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new();
        }

        foreach(var edge in edges) {
            int u = edge[0], v = edge[1];
            adj[u].Add(v);
            adj[v].Add(u);
        }


        DFS1(0, -1, adj, count, dis);
        DFS2(0, -1, adj, count, dis, n);

        return dis;
    }

    private void DFS1(int node, int parent, List<int>[] adj, int[] count, int[] dis) {
        count[node] = 1;

        foreach (var child in adj[node]) {
            if (child != parent) {
                DFS1(child, node, adj, count, dis);
                count[node] += count[child];
                dis[node] += dis[child] + count[child];
            }
        }
    }

    private void DFS2(int node, int parent, List<int>[] adj, int[] count, int[] dis, int n) {
        foreach (var child in adj[node]) {
            if (child != parent) {
                dis[child] = dis[node] + n - count[child] * 2;
                DFS2(child, node, adj, count, dis, n);
            }
        }
    }
}
